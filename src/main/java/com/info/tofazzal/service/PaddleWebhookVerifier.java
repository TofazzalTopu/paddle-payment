package com.info.tofazzal.service;

import com.info.tofazzal.util.PHPSerializer;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Signature;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import java.util.Map;
import java.util.TreeMap;

@Component
public class PaddleWebhookVerifier {

    private final String publicKeyPem;
    private static final String PADDLE_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\n...your_key_here...\n-----END PUBLIC KEY-----";

    public boolean verify(String signature, String rawData) {
        try {
            String cleanKey = PADDLE_PUBLIC_KEY.replaceAll("-----\\w+ PUBLIC KEY-----", "").replaceAll("\\s", "");
            byte[] keyBytes = Base64.decodeBase64(cleanKey);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(spec);

            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(publicKey);
            sig.update(rawData.getBytes(StandardCharsets.UTF_8));

            byte[] signatureBytes = Base64.decodeBase64(signature);
            return sig.verify(signatureBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public PaddleWebhookVerifier() throws IOException {
        // Read public key from classpath
        ClassPathResource resource = new ClassPathResource("paddle_public_key.pem");
        this.publicKeyPem = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    public boolean isValid(Map<String, String> formData) throws Exception {
        String pSignature = formData.remove("p_signature");
        Map<String, String> sorted = new TreeMap<>(formData); // Sorted alphabetically
        String serialized = PHPSerializer.serialize(sorted); // Serialize like PHP

        PublicKey publicKey = loadPublicKey(publicKeyPem);
        byte[] signatureBytes = Base64.decodeBase64(pSignature);

        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicKey);
        signature.update(serialized.getBytes(StandardCharsets.UTF_8));

        return signature.verify(signatureBytes);
    }

    private PublicKey loadPublicKey(String pem) throws Exception {
        String clean = pem.replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] keyBytes = Base64.decodeBase64(clean);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }
}

##   

1. Paddle Account Setup

```
Sign up at https://vendors.paddle.com

This is the Paddle Vendor Dashboard where you manage products, subscriptions, API keys, webhooks, etc.
```

2. Get Required Credentials
   ✅ YOUR_VENDOR_ID
   Go to Developers → Authentication in the vendor dashboard.
   This is your numeric Paddle Vendor ID.
3. ✅ YOUR_VENDOR_AUTH_CODE (aka API Key)
   Also found in Developers → Authentication
   You will see:
   Vendor ID
   API Key (aka Authentication Code) → copy and store securely

4. ✅ PADDLE PUBLIC KEY
   Go to Developers → Public Key
   Copy the whole public key including:

```agsl
vbnet
-----BEGIN PUBLIC KEY-----
...
-----END PUBLIC KEY-----
```

This key is used to verify webhook p_signature (like JWT verification)

5. p_signature (Webhook Signature)
   When Paddle sends a webhook (e.g., payment_succeeded, subscription_created), it includes a field:
```
p_signature=<base64-encoded signature>
You use this along with the Paddle public key to verify the webhook's authenticity in your backend.
```

6.  alert_name (Webhook Type)

Paddle webhooks include the field alert_name to specify the type of event. Examples include:

alert_name	Description
payment_succeeded	One-time product purchased
subscription_created	Subscription created
subscription_updated	Subscription plan/price changed
subscription_cancelled	Subscription was cancelled
subscription_payment_succeeded	Recurring payment succeeded
subscription_payment_failed	Recurring payment failed

See full list: https://developer.paddle.com/api-reference/webhooks/webhooks-overview

7.  Set Up Webhook URL
    Go to Developers → Webhooks

Add your backend webhook URL, e.g.:

https://your-domain.com/api/paddle/webhook
Choose which events to send (all are fine for now)

You can test webhooks with real transactions or via the Webhook Simulator

8. Enable HTTPS
   Paddle requires HTTPS for webhook delivery. Use:
   Let’s Encrypt for a production certificate
   ngrok or Cloudflare Tunnel for local development with HTTPS

9. Testing Payments
   To test checkout without charging real money:
   Go to Paddle Support and request Sandbox access
   Alternatively, set your product to "Test Mode"

10. Security Tips
    Area	Best Practice
    Webhook	Always verify p_signature with public key
    API Auth	Keep vendor_auth_code secret
    Retry Logic	Paddle retries failed webhooks 6 times
    Logging	Log alert_name, email, amount, passthrough for auditing

11. Additional Resources
    Paddle Documentation: https://developer.paddle.com/api-reference
    Webhook Simulator: https://vendors.paddle.com/webhook-simulator
    Paddle Support: https://paddle.com/support

 
14. 
```curl -X POST http://localhost:8080/api/paddle/webhook \
    -d "alert_name=subscription_created" \
    -d "event_time=2024-01-01 10:00:00" \
    -d "email=user@example.com" \
    -d "p_signature=FAKE_SIGNATURE"

```

15. Swagger UI
   You can access the Swagger UI at:
   http://localhost:8080/swagger-ui.html

   This provides an interactive API documentation interface for testing endpoints.
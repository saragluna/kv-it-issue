# KV issue

Reproduce steps:
- Replace the KV URL in `DemoApplication`.
- Make sure the local development env has credential stored, to use the DefaultAzureCredential.
- Install the latest version of KV from main branch (mine is built from git commit 751e18cbb6f).
- Run the application.


The stacktrace like:

```console

Exception in thread "main" com.azure.core.exception.ResourceModifiedException: Status code 400, "{"error":{"code":"BadParameter","message":"Property  has invalid value\r\n"}}"
	at com.azure.core.implementation.http.rest.RestProxyBase.instantiateUnexpectedException(RestProxyBase.java:366)
	at com.azure.core.implementation.http.rest.SyncRestProxy.ensureExpectedStatus(SyncRestProxy.java:121)
	at com.azure.core.implementation.http.rest.SyncRestProxy.handleRestReturnType(SyncRestProxy.java:206)
	at com.azure.core.implementation.http.rest.SyncRestProxy.invoke(SyncRestProxy.java:76)
	at com.azure.core.implementation.http.rest.RestProxyBase.invoke(RestProxyBase.java:110)
	at com.azure.core.http.rest.RestProxy.invoke(RestProxy.java:95)
	at com.sun.proxy.$Proxy3.setSecret(Unknown Source)
	at com.azure.security.keyvault.secrets.implementation.SecretClientImpl.setSecretWithResponse(SecretClientImpl.java:497)
	at com.azure.security.keyvault.secrets.SecretClient.setSecretWithResponse(SecretClient.java:147)
	at com.azure.security.keyvault.secrets.SecretClient.setSecret(SecretClient.java:118)
	at com.example.demo.DemoApplication.main(DemoApplication.java:19)
```


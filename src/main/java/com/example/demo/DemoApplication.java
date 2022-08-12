package com.example.demo;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

public class DemoApplication {
	private static final String NAME = "sample-key";
	private static final String VALUE = "sample-value";

	public static void main(String[] args) {

		SecretClient client = new SecretClientBuilder()
				.vaultUrl("https://springkv1.vault.azure.net/")
				.credential(new DefaultAzureCredentialBuilder().build())
				.buildClient();

		client.setSecret(NAME, VALUE);
		KeyVaultSecret secret = client.getSecret(NAME);
		System.out.println(secret.getValue());
	}

}

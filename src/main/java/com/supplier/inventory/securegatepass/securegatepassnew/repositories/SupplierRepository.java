package com.supplier.inventory.securegatepass.securegatepassnew.repositories;

import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class SupplierRepository {


	public static Firestore initializeFirestore() throws IOException {
		// Use the application default credentials
		GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(credentials)
				.setProjectId("gate-pass-bf346")
				.build();
		FirebaseApp.initializeApp(options);

		Firestore db = FirestoreClient.getFirestore();
		return db;
	}
}

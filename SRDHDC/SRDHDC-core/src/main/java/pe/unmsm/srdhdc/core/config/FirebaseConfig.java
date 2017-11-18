package pe.unmsm.srdhdc.core.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Configuration
public class FirebaseConfig {

	@Value(value = "classpath:${firebase.service.key.json}")
	private Resource serviceAccountKey;

	@Value("${firebase.database.url}")
	private String databaseUrl;
	
	@Bean
    public FirebaseApp provideFirebaseOptions() throws IOException {
//		URL url = getClass().getClassLoader().getResource("srdhdc-firebase-adminsdk-xt2cn-28c19c8bd4.json");
//		FileInputStream serviceAccount = new FileInputStream(url.getPath());
		
		FirebaseOptions options = new FirebaseOptions.Builder()
		  .setCredential(FirebaseCredentials.fromCertificate(serviceAccountKey.getInputStream()))
		  .setDatabaseUrl(databaseUrl)
		  .build();

        return FirebaseApp.initializeApp(options);
    }
	
	@Bean
    @Qualifier("main")
    public DatabaseReference provideDatabaseReference(FirebaseApp firebaseApp) {
        FirebaseDatabase
                .getInstance(firebaseApp)
                .setPersistenceEnabled(false);
        
        return FirebaseDatabase
                .getInstance(firebaseApp)
                .getReference();
    }
}

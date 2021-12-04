package pl.szymonleyk.spotifypartyapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.szymonleyk.spotifypartyapp.restclient.authorize.SpotifyRestClient;

@SpringBootApplication
public class SpotifyPartyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyPartyAppApplication.class, args);
	}
}

package io.nuwe.hackatonMWC;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.nuwe.hackatonMWC.domain.Country;
import io.nuwe.hackatonMWC.domain.GitProfile;
import io.nuwe.hackatonMWC.domain.GitProfileType;
import io.nuwe.hackatonMWC.domain.User;
import io.nuwe.hackatonMWC.repository.CountryRepository;
import io.nuwe.hackatonMWC.repository.GitProfileRepository;
import io.nuwe.hackatonMWC.repository.UserRepository;

@Component
public class InitialData {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GitProfileRepository gitProfileRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void populate() {
		
		User user1 = new User("60c4b7968c71c14b521ed76a", "TestUser01", "User011", "TestUser01@nuwe.io", true, passwordEncoder.encode("hackathonMWC"), "git1", "ES");
		User user2 = new User("60c4b7968c71c14b521ed76b", "TestUser02", "User02", "TestUser02@nuwe.io", true, passwordEncoder.encode("hackathonMWC"), "git2", "ES");
		userRepository.save(user2);
		userRepository.save(user1);
		
		Country spain = new Country("ES", "Spain", "ES", "ESP", 34);
		countryRepository.save(spain);
		
		GitProfile gitProfile1 = new GitProfile("git1", "User01Git", "https://github.com/user01Git", GitProfileType.GITHUBUSER, null, null);
		GitProfile gitProfile2 = new GitProfile("git2", "User02Git", "https://github.com/user02Git", GitProfileType.GITHUBUSER, null, null);
		gitProfileRepository.save(gitProfile1);
		gitProfileRepository.save(gitProfile2);
		
	};

}

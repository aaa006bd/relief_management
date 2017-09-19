package org.fteller;

import org.fteller.model.areas.UnionParisad;
import org.fteller.model.areas.repositories.UnionRepository;
import org.fteller.model.areas.Upazilla;
import org.fteller.model.areas.repositories.UpazillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class ReliefApplication implements CommandLineRunner {


    @Autowired
    private UnionRepository unionRepository;
    @Autowired
    private UpazillaRepository upazillaRepository;


	public static void main(String[] args) {

        SpringApplication.run(ReliefApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        UnionParisad chakar = new UnionParisad();
        UnionParisad laksmibazar = new UnionParisad();

        Upazilla banaripara = new Upazilla();
        banaripara.setName("banaripara");
        banaripara.setUnionParisads(new HashSet<UnionParisad>());

        chakar.setName("chakhar");
        chakar.setUpazilla(banaripara);
        laksmibazar.setName("laksmibazar");
        laksmibazar.setUpazilla(banaripara);


        banaripara.addUnions(chakar,laksmibazar);

        unionRepository.save(chakar);
        unionRepository.save(laksmibazar);
        upazillaRepository.save(banaripara);


    }
}

package org.fteller;

import org.fteller.model.areas.District;
import org.fteller.model.areas.Division;
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
        initalizeDB();


    }

    private void initalizeDB() {
	    //create union parisad
        UnionParisad chakar = new UnionParisad();
        UnionParisad laksmibazar = new UnionParisad();

        //create upazilla
        Upazilla banaripara = new Upazilla();
        banaripara.setName("banaripara");
        banaripara.setUnionParisads(new HashSet<UnionParisad>());

        //create district
        District barisal =  new District();
        barisal.setName("barisal sadar");
        barisal.setUpazillas(new HashSet<>());

        //create division
        Division barisalD = new Division();
        barisalD.setName("barisal");
        barisalD.setDistricts(new HashSet<>());

        barisal.setDivision(barisalD);
        barisal.addUpazillas(banaripara);

        chakar.setName("chakhar");
        chakar.setUpazilla(banaripara);
        laksmibazar.setName("laksmibazar");
        laksmibazar.setUpazilla(banaripara);

        banaripara.setDistrict(barisal);


        banaripara.addUnions(chakar,laksmibazar);

        unionRepository.save(chakar);
        unionRepository.save(laksmibazar);
      //  upazillaRepository.save(banaripara);
    }
}

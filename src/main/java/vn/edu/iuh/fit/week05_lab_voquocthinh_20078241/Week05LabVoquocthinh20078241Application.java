package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.enums.UserType;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.*;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.*;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.services.CandidateSkillService;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Week05LabVoquocthinh20078241Application {

	public static void main(String[] args) {
		SpringApplication.run(Week05LabVoquocthinh20078241Application.class, args);
	}

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private JobSkillRepository jobSkillRepository;
//	@Bean
	CommandLineRunner initData(){
		return args -> {
			Random rnd =new Random();
//			for (int i = 1; i < 1000; i++) {
//				Address add = new Address(rnd.nextInt(1,1000)+"","Quang Trung","HCM",
//						rnd.nextInt(70000,80000)+"", CountryCode.VN );
//				addressRepository.save(add);
//
//				Candidate can=new Candidate("Name #"+i,
//						LocalDate.of(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)),
//						rnd.nextLong(1111111111L,9999999999L)+"",
//						"email_"+i+"@gmail.com",
//						add);
//			}

			for (int i = 1; i < 1000; i++) {
				User user = new User("user"+i, "password"+i, UserType.COMPANY_USER);
				userRepository.save(user);

				Address add = new Address(rnd.nextInt(1,1000)+"","Quang Trung","HCM",
						rnd.nextInt(70000,80000)+"", CountryCode.VN );

				addressRepository.save(add);
				Company company = new Company("Name #"+i, "About #"+i,
						add,
						rnd.nextLong(1111111111L,9999999999L)+"",
						"email_"+i+"@gmail.com",
						"https://company"+i+".vn",
						null,
						user
						);

				Job job=new Job("Name #"+i, "Description #"+i, company,null);

				JobSkill jobSkill = new JobSkill(skillRepository.findById(1L).get(),job, SkillLevel.MASTER,"None");
				JobSkill jobSkill2 = new JobSkill(skillRepository.findById(5L).get(),job, SkillLevel.ADVANCED,"None");
				JobSkill jobSkill3 = new JobSkill(skillRepository.findById(7L).get(),job, SkillLevel.ADVANCED,"None");
				jobSkillRepository.save(jobSkill);
				jobSkillRepository.save(jobSkill2);
				jobSkillRepository.save(jobSkill3);
				List<JobSkill> list = List.of(jobSkill,jobSkill2, jobSkill3);
				job.setJobSkills(list);
				jobRepository.save(job);

				List<Job> jobs = List.of(job);
				company.setJobs(jobs);
				companyRepository.save(company);
			}
		};
	}
}

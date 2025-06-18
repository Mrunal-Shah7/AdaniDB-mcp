package com.xenostar.adaniDB;

import com.xenostar.adaniDB.Repositories.*;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdaniDbApplication {


	public static void main(String[] args) {SpringApplication.run(AdaniDbApplication.class, args);}

	@Bean
	public List<ToolCallback> myTools(
			au2024Repository au2024Repository,
			bdays2022Repository bdays2022Repository,
			btech2022Repository btech2022Repository,
			btech2023Repository btech2023Repository,
			btech2024_2Repository btech2024_2Repository,
			btech2024_3Repository btech2024_3Repository,
			btech2024Repository btech2024Repository,
			cse2022Repository cse2022Repository,
			icta2022Repository icta2022Repository,
			ictb2022Repository ictb2022Repository

	) {
		return List.of(ToolCallbacks.from(
				au2024Repository, bdays2022Repository,btech2022Repository,btech2023Repository,btech2024_2Repository,
				btech2024_3Repository,btech2024Repository,cse2022Repository,icta2022Repository,ictb2022Repository
		));
	}


}

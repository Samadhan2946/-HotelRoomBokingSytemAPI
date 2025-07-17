	package com.rt.entity;
	
	import java.time.LocalDate;
	
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	
	import org.hibernate.annotations.GeneratorType;
	import org.springframework.format.annotation.DateTimeFormat;
	
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	
	@Entity
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Table(name="staff")
	public class Staff {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
	
		private String fullName;
		private String email;
		private String phoneNumber;
		private String gender;
	
		/*
		 * @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate dateOfBirth;
		 */
	
		private String address;
	
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate joiningDate;
	
		private String department; // Dropdown: Manager, Cleaner, Receptionist
	
	}

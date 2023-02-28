-- salary_calculation.employee definition

CREATE TABLE `employee` (
  `NIK` varchar(255) NOT NULL,
  `FULL_NAME` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `PHONE_NO` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`NIK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- salary_calculation.employee_salary definition

CREATE TABLE `employee_salary` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NIK` varchar(255) NOT NULL,
  `POKOK` bigint NOT NULL DEFAULT '0',
  `TUNJANGAN` bigint NOT NULL DEFAULT '0',
  `BONUS` bigint NOT NULL DEFAULT '0',
  `POTONGAN` bigint NOT NULL DEFAULT '0',
  `PAJAK` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `NIK` (`NIK`),
  CONSTRAINT `NIK` FOREIGN KEY (`NIK`) REFERENCES `employee` (`NIK`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
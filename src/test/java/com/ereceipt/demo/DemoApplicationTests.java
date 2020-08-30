package com.ereceipt.demo;

import com.ereceipt.demo.dao.PatientRepository;
import com.ereceipt.demo.dao.PharmacistRepository;
import com.ereceipt.demo.dao.PrescriptionRepository;
import com.ereceipt.demo.domain.*;
import com.ereceipt.demo.service.DoctorService;
import com.ereceipt.demo.service.HospitalService;
import com.ereceipt.demo.service.PatientService;
import com.ereceipt.demo.service.PharmaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ComponentScan(basePackages = "com.ereceipt.demo.service")
public class DemoApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	private final DoctorService doctorService;
	private final HospitalService hospitalService;
	private final PatientService patientService;
	private final PatientRepository patientRepository;
	private final PrescriptionRepository prescriptionRepository;
	private final PharmaService pharmaService;
	private final PharmacistRepository pharmacistRepository;

	@Autowired
	public DemoApplicationTests(DoctorService doctorService, PatientService patientService,
								HospitalService hospitalService, PatientRepository patientRepository,
								PrescriptionRepository prescriptionRepository, PharmaService pharmaService,
								PharmacistRepository pharmacistRepository) {
		this.doctorService = doctorService;
		this.patientService = patientService;
		this.hospitalService = hospitalService;
		this.patientRepository = patientRepository;
		this.prescriptionRepository = prescriptionRepository;
		this.pharmaService = pharmaService;
		this.pharmacistRepository = pharmacistRepository;

	}

	@Test
	void testFindAllHospitals(){
		assertThat(hospitalService.findAllHospitals(),hasSize(0));
		Hospital hospital = new Hospital("Test Hospital");
		Hospital savedHospital = hospitalService.addNewHospital(hospital);
		assertThat(hospitalService.findAllHospitals(),hasSize(1));
	}

	@Test
	void testAddNewHospital() {
		Hospital hospital = new Hospital("Test Hospital");
		Hospital savedHospital = hospitalService.addNewHospital(hospital);
		assertTrue(savedHospital.equals(hospital));
		assertThat(hospitalService.findAllHospitals(),hasSize(1));
	}

	@Test
	void testFindAllDoctorsMethod() {
		List<Doctor> doctors = doctorService.findAllDoctors();
		assertThat(doctors,hasSize(0));
	}

	@Test
	void testSaveNewDoctor() {
		assertThat(doctorService.findAllDoctors(),hasSize(0));

		Doctor doctor = new Doctor();
		doctor.setUsername("testdoc");
		doctor.setPassword("testdoc");
		doctor.setFirstName("testName");
		doctor.setLastName("testLastName");
		doctor.setEmail("test@doc.gm");

		doctorService.saveNewDoctor(doctor);
		assertThat(doctorService.findAllDoctors(),hasSize(1));
		assertTrue(doctorService.findAllDoctors().get(0).equals(doctor));
	}

	@Test
	void testFindDoctorByUsername() {
		Doctor doctor = new Doctor();
		doctor.setUsername("testdoc");
		doctor.setPassword("testdoc");
		doctor.setFirstName("testName");
		doctor.setLastName("testLastName");
		doctor.setEmail("test@doc.gm");
		doctorService.saveNewDoctor(doctor);

	    Doctor foundDoctor = doctorService.findDoctorByUsername("testdoc").get();
		assertTrue(doctor.equals(foundDoctor));
	}

	@Test
	void testFindDoctorByUsernameAndPassword() {
		Doctor doctor = new Doctor();
		doctor.setUsername("testdoc");
		doctor.setPassword("testdoc");
		doctor.setFirstName("testName");
		doctor.setLastName("testLastName");
		doctor.setEmail("test@doc.gm");
		doctorService.saveNewDoctor(doctor);

		Doctor foundDoctor = doctorService.findDoctorByUsernameAndPassword("testdoc","testdoc");
		assertTrue(doctor.equals(foundDoctor));
	}

	@Test
	void testAddNewPatient() {
		assertThat(patientRepository.findAll(),hasSize(0));

		Doctor doctor = new Doctor();
		doctor.setUsername("testdoc");
		doctor.setPassword("testdoc");
		doctor.setFirstName("testName");
		doctor.setLastName("testLastName");
		doctor.setEmail("test@doc.gm");
		Doctor savedDoctor = doctorService.saveNewDoctor(doctor);

		Patient patient = new Patient();
		patient.setDoctor(savedDoctor);
		patient.setFirstName("Pablo");
		patient.setLastName("Picassi");
		LocalDate date = LocalDate.parse("2020-01-08");
		patient.setBirthdate(date);

		patientService.addNewPatient(patient);

		assertTrue(patientRepository.findAll().get(0).equals(patient));
		assertThat(patientRepository.findAll(),hasSize(1));
	}

	@Test
	void testAddNewPrescription() {
		assertThat(prescriptionRepository.findAll(),hasSize(0));

		Doctor doctor = new Doctor();
		doctor.setUsername("testdoc");
		doctor.setPassword("testdoc");
		doctor.setFirstName("testName");
		doctor.setLastName("testLastName");
		doctor.setEmail("test@doc.gm");
		Doctor savedDoctor = doctorService.saveNewDoctor(doctor);

		Patient patient = new Patient();
		patient.setDoctor(savedDoctor);
		patient.setFirstName("Pablo");
		patient.setLastName("Picassi");
		LocalDate date = LocalDate.parse("2020-01-08");
		patient.setBirthdate(date);

		Patient savedPatient = patientService.addNewPatient(patient);

		Prescription prescription = new Prescription();
		prescription.setDoctor(savedDoctor);
		prescription.setMedicineName("Mezym");
		prescription.setPatient(savedPatient);
		prescription.setPrescrCode("QwErTY12");

		doctorService.addNewPrescription(prescription);

		assertTrue(prescriptionRepository.findAll().get(0).equals(prescription));
		assertThat(prescriptionRepository.findAll(),hasSize(1));
	}

	@Test
	void testAddNewPharmacist() {
		assertThat(pharmacistRepository.findAll(),hasSize(0));
		Pharmacist pharmacist = new Pharmacist();
		pharmacist.setUsername("testPharma");
		pharmacist.setPassword("testPharma");
		pharmacist.setFirstName("testName");
		pharmacist.setLastName("testLastName");
		pharmacist.setEmail("test@pharma.gm");
		pharmaService.addNewPharmacist(pharmacist);

		assertThat(pharmacistRepository.findAll(),hasSize(1));
		assertTrue(pharmacistRepository.findAll().get(0).equals(pharmacist));
	}

	@Test
	void testFindPharmacistByUsername() {

		Pharmacist pharmacist = new Pharmacist();
		pharmacist.setUsername("testPharma");
		pharmacist.setPassword("testPharma");
		pharmacist.setFirstName("testName");
		pharmacist.setLastName("testLastName");
		pharmacist.setEmail("test@pharma.gm");
		pharmaService.addNewPharmacist(pharmacist);

		assertTrue(pharmaService.findPharmacistByUsername("testPharma").equals(pharmacist));
	}

	@Test
	void findPharmacistByUsernameAndPassword() {

		Pharmacist pharmacist = new Pharmacist();
		pharmacist.setUsername("testPharma");
		pharmacist.setPassword("testPharma");
		pharmacist.setFirstName("testName");
		pharmacist.setLastName("testLastName");
		pharmacist.setEmail("test@pharma.gm");
		pharmaService.addNewPharmacist(pharmacist);

		assertTrue(pharmaService.findPharmacistByUsernameAndPassword("testPharma","testPharma").equals(pharmacist));
	}

	@Test
	void testFindPrescriptionByItsCode() {

		Doctor doctor = new Doctor();
		doctor.setUsername("testdoc");
		doctor.setPassword("testdoc");
		doctor.setFirstName("testName");
		doctor.setLastName("testLastName");
		doctor.setEmail("test@doc.gm");
		Doctor savedDoctor = doctorService.saveNewDoctor(doctor);

		Patient patient = new Patient();
		patient.setDoctor(savedDoctor);
		patient.setFirstName("Pablo");
		patient.setLastName("Picassi");
		LocalDate date = LocalDate.parse("2020-01-08");
		patient.setBirthdate(date);

		Patient savedPatient = patientService.addNewPatient(patient);

		Prescription prescription = new Prescription();
		prescription.setDoctor(savedDoctor);
		prescription.setMedicineName("Mezym");
		prescription.setPatient(savedPatient);
		prescription.setPrescrCode("QwErTY12");

		doctorService.addNewPrescription(prescription);

		assertTrue(pharmaService.findPrescriptionByItsCode("QwErTY12").equals(prescription));
	}

	@Test
	void testFindPrescriptionById() {

		Doctor doctor = new Doctor();
		doctor.setUsername("testdoc");
		doctor.setPassword("testdoc");
		doctor.setFirstName("testName");
		doctor.setLastName("testLastName");
		doctor.setEmail("test@doc.gm");
		Doctor savedDoctor = doctorService.saveNewDoctor(doctor);

		Patient patient = new Patient();
		patient.setDoctor(savedDoctor);
		patient.setFirstName("Pablo");
		patient.setLastName("Picassi");
		LocalDate date = LocalDate.parse("2020-01-08");
		patient.setBirthdate(date);

		Patient savedPatient = patientService.addNewPatient(patient);

		Prescription prescription = new Prescription();
		prescription.setDoctor(savedDoctor);
		prescription.setMedicineName("Mezym");
		prescription.setPatient(savedPatient);
		prescription.setPrescrCode("QwErTY12");

		doctorService.addNewPrescription(prescription);

		assertTrue(pharmaService.findPrescriptionById(prescription.getPrescrId()).equals(prescription));
	}

	@Test
	void testSavePrescription() {
		assertThat(prescriptionRepository.findAll(),hasSize(0));

		Doctor doctor = new Doctor();
		doctor.setUsername("testdoc");
		doctor.setPassword("testdoc");
		doctor.setFirstName("testName");
		doctor.setLastName("testLastName");
		doctor.setEmail("test@doc.gm");
		Doctor savedDoctor = doctorService.saveNewDoctor(doctor);

		Patient patient = new Patient();
		patient.setDoctor(savedDoctor);
		patient.setFirstName("Pablo");
		patient.setLastName("Picassi");
		LocalDate date = LocalDate.parse("2020-01-08");
		patient.setBirthdate(date);

		Patient savedPatient = patientService.addNewPatient(patient);

		Prescription prescription = new Prescription();
		prescription.setDoctor(savedDoctor);
		prescription.setMedicineName("Mezym");
		prescription.setPatient(savedPatient);
		prescription.setPrescrCode("QwErTY12");

		doctorService.addNewPrescription(prescription);

		assertThat(prescriptionRepository.findAll(),hasSize(1));

		Prescription foundPrescription = pharmaService.findPrescriptionByItsCode("QwErTY12");
		foundPrescription.setHanded(true);

		pharmaService.savePrescription(foundPrescription);

		assertTrue(prescriptionRepository.findAll().get(0).equals(foundPrescription));
		assertThat(prescriptionRepository.findAll(),hasSize(1));
	}

}

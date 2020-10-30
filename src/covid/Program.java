package covid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args)throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new FileReader("datos-covid.txt"));
		
		int quantCountries = Integer.parseInt(bf.readLine());

		String[]arrDataCountries;
		String[]arrDataPatient;
		String[]arrDataSymptom;
		
		for(int k=0; k<quantCountries;k++) {
			arrDataCountries = bf.readLine().split(",");
			Country country = new Country(arrDataCountries[0]);
			int quantPatients = Integer.parseInt(arrDataCountries[1]);
			
			for(int i=0;i<quantPatients;i++) {
				arrDataPatient = bf.readLine().split(",");
				Patient patient = new Patient(arrDataPatient[0], Integer.parseInt(arrDataPatient[1]), Integer.parseInt(arrDataPatient[2]));
				int quantSymptoms = Integer.parseInt(arrDataPatient[3]);
				
				for(int j=0; j<quantSymptoms;j++) {
					arrDataSymptom = bf.readLine().split(",");
					Symptom symptoms = new Symptom(Integer.parseInt(arrDataSymptom[0]));
					patient.addSymptoms(symptoms);
				}
				country.addPatient(patient);
			}
			//PUNTO 1: Buscar paciente por ID y mostrar sus síntomas
			Patient search = country.search(16);
			
			if(search==null) {
				System.out.println("Patient NOT found");
			}

			else {
				SymptomList listSymptom = search.listSymptom;
				//Mostrar síntomas del paciente buscado.
				System.out.print("Patient, name: " + search.name);
				System.out.print("\nSymptoms: ");
				
				SymptomNode tmp = listSymptom.head;
				int copy = search.quantSymptom;
				for(int g=0; g<copy;g++) {
					if(search.quantSymptom == 1) {
						System.out.println(tmp.symptom.symptomName);
					}
					if(search.quantSymptom > 1) {
					while(tmp!=null) {
						if(tmp.next == null) {
							System.out.println(" y " + tmp.symptom.symptomName);
						}
						else{
						System.out.print(tmp.symptom.symptomName + ", ");
						}
						tmp = tmp.next;
					}
					}
				}
			}
			//Fin PUNTO 1
			
			//PUNTO 2: Mostrar el valor a pagar según el número de sintomas;
			Patient accountXPayment = country.search(15);
			if(accountXPayment==null) {
				System.out.println("\nPatient NOT found");
			}
			else {
			float total = accountXPayment.totalXPay(accountXPayment);
			System.out.println("The patient "+ accountXPayment.name + " tiene "+ accountXPayment.quantSymptom + " symtoms, your payment is: "+ total);
			}
			//FIN PUNTO 2.
			
			//PUNTO 3: Cuantos pacientes tienen fiebre en los sintomas reportados
			int totalFever = country.totalFever(country.root);
			System.out.println("Quantity patients with fever: " + totalFever);
			
			int symptomMostCommon = country.symptomMostCommon(country.root);
			if(symptomMostCommon == 0) {
				country.nameSymptomMostCommon = "Fever";
			}
			if(symptomMostCommon == 1) {
				country.nameSymptomMostCommon = "General Discomfort";
			}
			if(symptomMostCommon == 2) {
				country.nameSymptomMostCommon = "Headache";
			}
			if(symptomMostCommon == 3) {
				country.nameSymptomMostCommon = "Sore Throat";
			}
			System.out.println("The symptom most common is: " + country.nameSymptomMostCommon);
			
			float totalAverage = country.averagePayment(country.root);
			totalAverage = totalAverage /quantPatients;
			System.out.println("Payment average for all patients is: " + totalAverage);
			
			Patient patientMostSymptoms = country.patientMostSymptoms(country.root);
			System.out.println(patientMostSymptoms.name);
		}
		
	}

}


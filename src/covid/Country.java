package covid;

public class Country {

	String nameCountry;
	
	PatientNode root;
	SymptomList listaSintoma;
	int fever;
	int countF;
	int countMG;
	int countDC;
	int countDG;
	float average;
	
	public Country(String country) {
		this.nameCountry = country;
	}


	public void addPatient(Patient patient) {
		if(root == null) {
			root = new PatientNode(patient);
			return;
		}
		addPatient(root, patient);
		}
		
	
	private void addPatient(PatientNode node, Patient patient) {
		if(node==null) {
			return;
		}
		if(patient.id > node.patient.id) {
			if(node.right == null) {
				if(patient.id != node.patient.id) {
					node.right = new PatientNode(patient);
				}
				else {
					System.out.println("Patient " + patient.name + " with ID " + patient.id + " duplicated");
				}
			}
			else {
				addPatient(node.right, patient);
			}
		}
		else {
			if(node.left==null) {
				if(patient.id != node.patient.id) {
					node.left = new PatientNode(patient);
				}
				else {
					System.out.println("Patient " + patient.name + " with ID " + patient.id + " duplicated");
				}
				
			}
			else {
				addPatient(root.left, patient);
			}
		}
	}
	
	public Patient search(int id) {
		return search(root, id);
	}
	
	public Patient search(PatientNode node, int id) {
		if(node==null) {
			return null;
		}
		if(node.patient.id == id) {
			return node.patient;
		}
		if(node.patient.id < id) {
			return search(node.right, id);
		}
		return search(node.left, id);
	}
	
	public void patientsWithFever() {
		totalFever(root);
	}
	
	public int totalFever(PatientNode node) {
		if(node==null) {
			return 0;
		}
		fever = fever + node.patient.countFever(node);
		totalFever(node.right);
		totalFever(node.left);
		
		return fever;
	}
	
	PatientNode pacienteRoot;
	PatientNode pacienteIzq;
	PatientNode pacienteDer;
	public void symptomMostCommon() {
		
		pacienteRoot = root;
		symptomMostCommon(pacienteRoot);
	}
	
	String nameSymptomMostCommon;
	public int symptomMostCommon(PatientNode node) {
		if(node == null) {
			return 0;
		}
		node.patient.countSymptoms(node);
		int mostCommon = 0;
		
		countDC = countDC + node.patient.countDC;
		countDG = countDG + node.patient.countDG;
		countF = countF + node.patient.countF;
		countMG = countMG + node.patient.countMG;
		
		symptomMostCommon(node.left);
		symptomMostCommon(node.right);
		
		if(countDC > countDG && countDC > countF && countDC > countMG) {
			mostCommon = 2;
		}
		else if(countDG > countF && countDG > countDC && countDG > countMG) {
			mostCommon = 3;
		}
		else if(countF > countMG && countF > countDG && countF > countDC) {
			mostCommon = 0;
		}
		else if(countMG > countF && countMG > countDC && countMG > countDG) {
			mostCommon = 1;
		}
		
		return mostCommon;
	}
	
	public void inicioPromedio(PatientNode node) {
		averagePayment(root);
	}
	
	public float averagePayment(PatientNode node) {
		if(node == null) {
			return 0;
		}
		average = average + node.patient.totalXPay(node.patient);
		
		averagePayment(node.right);
		averagePayment(node.left);
		
		return average;
	}
	
	public void mostSymptoms(PatientNode node) {
		patientMostSymptoms(root);
	}
	
	Patient patientMostSymptoms(PatientNode node) {
		if(node==null) {
			return null;
		}
		

		Patient patientMostSymptoms = null;
		int masSintomas = node.patient.quantSymptom;
		
		if(root.patient.quantSymptom > node.right.patient.quantSymptom) {
			patientMostSymptoms = root.patient;
		}
		else if(node.right.patient.quantSymptom > node.left.patient.quantSymptom){
			patientMostSymptoms = node.right.patient;
		}
		else {
			patientMostSymptoms = node.left.patient;
		}
		return patientMostSymptoms;		
	}
}
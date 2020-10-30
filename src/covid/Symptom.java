package covid;

public class Symptom {

	SymptomList listSymptom;
	
	int idSymptom;
	String symptomName;
	int countFever;
	int countDiscomfort;
	int countHC;
	int countST;
	
	Symptom(int symptom) {
		if(symptom == 0) {
			symptomName = "Fever";
			countFever = countFever + 1;
		}
		else if(symptom == 1) {
			symptomName = "General Discomfort";
			countDiscomfort = countDiscomfort +1;
		}
		else if(symptom == 2) {
			symptomName = "Headache";
			countHC = countHC + 1;
		}
		else if(symptom == 3) {
			symptomName = "Sore Throat";
			countST = countST + 1;
		}
		idSymptom = symptom;
	}
	
	public Symptom() {
		listSymptom = new SymptomList();
	}
	
	boolean Fiebre() {
		if(idSymptom == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

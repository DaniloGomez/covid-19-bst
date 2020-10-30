package covid;

public class Patient {

	String name;
	int quantSymptom;
	int id;
	int verif =0;
	String nameSymptom;
	int countF;
	int countMG;
	int countDC;
	int countDG;
	
	SymptomList listSymptom;
	
	int capacityId = 1000;
	public int quantityId = 0;
	
	int[] arrId;
	
	public Patient(String name, int ide, int quantitySympt) {
		this.id = ide;
		this.name = name;
		if(quantityId!=0 && ide!=0) {
		for(int i=0; i<quantityId; i++) {
			if(this.id != arrId[i]) {
				verif=1;
			}
			if(this.id == arrId[i]) {
				return;
			}
		}
		}
		this.quantSymptom = quantitySympt;
		listSymptom = new SymptomList();
	}
	
	public float totalXPay(Patient patient) {
		float total=0;
		
		total = 100 * quantSymptom;
		return total;
	}
	public int countFever;
	void addSymptoms(Symptom symptom) {
		listSymptom.insertSymptom(symptom);
	}
	
	int countFever(PatientNode node) {
		if(node == null) {
			return 0;
		}
		SymptomNode tmp = listSymptom.head;
		while(tmp!=null) {
			if(tmp.symptom.Fiebre() == true) {
				countFever++;
				//System.out.println(contadorFiebre);
			}
			tmp=tmp.next;
		}
		return node.patient.countFever;		
	}
	
	void countSymptoms(PatientNode node) {
		if(node == null) {
			return;
		}
		SymptomNode tmp = listSymptom.head;
		while(tmp != null) {
			if(tmp.symptom.idSymptom == 0) {
				countF++;
			}
			if(tmp.symptom.idSymptom == 1) {
				countMG++;
			}
			if(tmp.symptom.idSymptom == 2) {
				countDC++;
			}
			if(tmp.symptom.idSymptom == 3) {
				countDG++;
			}
			tmp = tmp.next;
		}
	}
}

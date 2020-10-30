package covid;

public class PatientNode {

	public PatientNode(Patient patient) {
		this.patient = patient;
	}
	Patient patient;
	PatientNode left;
	PatientNode right;
	
}

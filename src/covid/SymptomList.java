package covid;

public class SymptomList {

	SymptomNode head;
	
	void insertSymptom(Symptom s) {
		SymptomNode newNode = new SymptomNode();
		newNode.symptom = s;
		
		if(head==null) {
			head=newNode;
		}
		else {
			SymptomNode tmp = head;
			while(tmp.next !=null) {
				tmp=tmp.next;
			}
			tmp.next = newNode;
		}
	}
	
}

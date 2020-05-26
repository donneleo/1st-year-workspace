import java.util.Scanner; 
import javax.swing.JOptionPane;


   public class Animal {

	public static void main(String[] args) {
		
		int answerBlood = JOptionPane.showConfirmDialog(null, "Is this animal cold-blooded?");
		boolean coldblood = (answerBlood == JOptionPane.YES_OPTION);
			
		if(coldblood)
		{
			int answerFins = JOptionPane.showConfirmDialog(null, "Does this animal have fins?");
			boolean fins = (answerFins == JOptionPane.YES_OPTION);
			if (fins){
			      JOptionPane.showMessageDialog(null, "Your animal is a fish.");
			          }
			else {
				  int answerScales = JOptionPane.showConfirmDialog(null, "Does this animal have scales?");
				  boolean scales = (answerScales == JOptionPane.YES_OPTION);
				  if(scales) { 
					  JOptionPane.showMessageDialog(null, "Your animal is a reptile.");
				             }
				  else {
					    JOptionPane.showMessageDialog(null,  "Your animal is an amphibian.");
				       }
			}
		}
		else {
			  int answerFeathers = JOptionPane.showConfirmDialog(null, "Does your animal have feathers?");
			  boolean feathers = (answerFeathers == JOptionPane.YES_OPTION);
			  if (feathers) {
				   JOptionPane.showMessageDialog(null, "Your animal is a bird.");
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "Your animal is a mammal.");
			  }
		}
	}

   }

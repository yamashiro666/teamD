// 10�s��12�s��18�s��24�s��26�`31�s�ڂ��C��

package display1;

public class StartDisplay extends Display{

	@Override
	public void selector(){
		
		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��
		
			super.input();
			
			if(getPressedKey() == '2'){  //Exit���C���X�^���X�����y�ѕ\��
				
				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;
				
			}else if(getPressedKey() == '1'){  //CouseSelect���C���X�^���X�����y�ѕ\��
				
				CourseSlect course = new CourseSlect();
				course.display("CourseSelect.txt");
				// course.input();
				course.selector();
				flag = false;
				
			}else{  //���͂������l���������Ȃ��ꍇ���[�v����
				System.out.println("�������l����͂��Ă�������");
			}
		}
	}
}
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class turing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char cin[]=Stringinput();
		//��ʼ��״̬ת�Ƽ���
		ArrayList<State_trans> State_trans_list=State_trans_init();
		
		//State_trans_print(State_trans_list);
		if(Stringaccept(cin,State_trans_list))
			System.out.println("�ַ�����ͼ�������!");
		else
			System.out.println("�ַ�������ͼ�������!");
	}
	//�����ַ���
		public static char[] Stringinput()
		{
			System.out.println("�������ʶ����ַ���(��:#a*+a*=a*)��");
			//���ַ������ַ�������
			Scanner sc = new Scanner(System.in);
			String str=sc.next();
			str+="$";
			//System.out.println(str);
			char cin[] = str.toCharArray();//����toCharArray����ת��
			sc.close();
			return cin;
		}
			
		//��ʼ��״̬ת�ƹ�ϵ
		public static ArrayList<State_trans> State_trans_init() {
			//���ܾ�״̬��NO��ʾ�����մ���#��ʾ
			ArrayList<State_trans> list = new ArrayList<State_trans>();
			list.add(new State_trans("q0",'#',"q1",'#',"R"));
			list.add(new State_trans("q1",'a',"q1",'#',"R"));
			list.add(new State_trans("q1",'+',"q2",'#',"R"));
			list.add(new State_trans("q2",'a',"q2",'#',"R"));
			list.add(new State_trans("q2",'=',"q3",'#',"R"));
			list.add(new State_trans("q3",'a',"q3",'#',"R"));
			list.add(new State_trans("q3",'$',"q4",'#',"L"));
			list.add(new State_trans("q4",'+',"q4",'#',"L"));
			list.add(new State_trans("q4",'a',"q4",'#',"L"));
			list.add(new State_trans("q4",'=',"q4",'#',"L"));
			list.add(new State_trans("q4",'x',"q4",'#',"L"));
			list.add(new State_trans("q4",'$',"q4",'#',"L"));
			list.add(new State_trans("q4",'#',"q5",'#',"L"));
			list.add(new State_trans("q5",'#',"q6",'#',"R"));
			list.add(new State_trans("q6",'x',"q6",'#',"R"));
			list.add(new State_trans("q6",'+',"q6",'#',"R"));
			list.add(new State_trans("q6",'a',"q7",'x',"R"));
			list.add(new State_trans("q7",'a',"q7",'#',"R"));
			list.add(new State_trans("q7",'+',"q7",'#',"R"));
			list.add(new State_trans("q7",'=',"q8",'#',"R"));
			list.add(new State_trans("q8",'x',"q8",'#',"R"));
			list.add(new State_trans("q8",'a',"q4",'x',"R"));
			list.add(new State_trans("q6",'=',"q9",'#',"R"));
			list.add(new State_trans("q9",'x',"q9",'#',"R"));
			list.add(new State_trans("q9",'$',"q10",'#',"R"));
			
			return list;
		}
		//���״̬ת�ƹ�ϵ
		public static void State_trans_print(ArrayList<State_trans> State_trans_list)
		{
			System.out.println("--------------------------------------------");
			System.out.println("-----------------״̬ת�ƹ�ϵ----------------");
			System.out.println("��ǰ״̬--�ַ�--ת��״̬--�ı�Ԫ��--�ƶ�����");
			for(Iterator iterator=State_trans_list.iterator();iterator.hasNext();)
			{
				State_trans tran=(State_trans)iterator.next();
				System.out.println(tran.getOldState()+"-------"+tran.getTrans()+"-------"+tran.getNewState()+"-------"+tran.getTranschar()+"-------"+tran.getDirection());
			}
			
		}
		//�ж��ַ����Ƿ񱻽���
		public static boolean Stringaccept(char cin[],ArrayList<State_trans> State_trans_list)
		{
			//��ʼ��״̬����
			String currentState="q0";
			int index=0;//ָ��λ��
			boolean trans;//�Ƿ��ҵ���Ӧ״̬ת�ƹ�ϵ
			//���ַ������д����������ս�״̬q10�˳�
			while(!currentState.equals("q10"))
			{
				trans=false;
				for(State_trans stateTr : State_trans_list)
				{
					//�ҵ�״̬���ַ�ƥ���ת������
					if(stateTr.getOldState().equals(currentState)&&stateTr.getTrans()==cin[index])
						{
							trans=true;
							currentState=stateTr.getNewState();
							//�滻Ԫ��
							if(stateTr.getTranschar()!='#')
							{
								cin[index]=stateTr.getTranschar();
							}
							//ָ���ƶ�����
							if(stateTr.getDirection().equals("R"))
								index++;
							else
								index=0>index-1?0:index-1;
						}
				}
				//��û���ҵ���Ӧת���������ַ�����������
				if(!trans)
					return false;
			}
			return true;
		}
}

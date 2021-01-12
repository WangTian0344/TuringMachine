import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class turing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char cin[]=Stringinput();
		//初始化状态转移集合
		ArrayList<State_trans> State_trans_list=State_trans_init();
		
		//State_trans_print(State_trans_list);
		if(Stringaccept(cin,State_trans_list))
			System.out.println("字符串被图灵机接受!");
		else
			System.out.println("字符串不被图灵机接受!");
	}
	//接收字符串
		public static char[] Stringinput()
		{
			System.out.println("请输入待识别的字符串(例:#a*+a*=a*)：");
			//将字符存入字符数组中
			Scanner sc = new Scanner(System.in);
			String str=sc.next();
			str+="$";
			//System.out.println(str);
			char cin[] = str.toCharArray();//利用toCharArray方法转换
			sc.close();
			return cin;
		}
			
		//初始化状态转移关系
		public static ArrayList<State_trans> State_trans_init() {
			//将拒绝状态用NO表示，将空串用#表示
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
		//输出状态转移关系
		public static void State_trans_print(ArrayList<State_trans> State_trans_list)
		{
			System.out.println("--------------------------------------------");
			System.out.println("-----------------状态转移关系----------------");
			System.out.println("当前状态--字符--转移状态--改变元素--移动方向");
			for(Iterator iterator=State_trans_list.iterator();iterator.hasNext();)
			{
				State_trans tran=(State_trans)iterator.next();
				System.out.println(tran.getOldState()+"-------"+tran.getTrans()+"-------"+tran.getNewState()+"-------"+tran.getTranschar()+"-------"+tran.getDirection());
			}
			
		}
		//判断字符串是否被接受
		public static boolean Stringaccept(char cin[],ArrayList<State_trans> State_trans_list)
		{
			//初始化状态对象
			String currentState="q0";
			int index=0;//指针位置
			boolean trans;//是否找到对应状态转移关系
			//对字符串进行处理，当进入终结状态q10退出
			while(!currentState.equals("q10"))
			{
				trans=false;
				for(State_trans stateTr : State_trans_list)
				{
					//找到状态与字符匹配的转移条件
					if(stateTr.getOldState().equals(currentState)&&stateTr.getTrans()==cin[index])
						{
							trans=true;
							currentState=stateTr.getNewState();
							//替换元素
							if(stateTr.getTranschar()!='#')
							{
								cin[index]=stateTr.getTranschar();
							}
							//指针移动方向
							if(stateTr.getDirection().equals("R"))
								index++;
							else
								index=0>index-1?0:index-1;
						}
				}
				//当没有找到对应转移条件，字符串不被接受
				if(!trans)
					return false;
			}
			return true;
		}
}

package qiye.learnjava.interfaces;

public interface IInterface {
	//�ӿ������еķ����Զ�ΪpublicҲֻ����public
	protected void out();
	void out(String str);
	public void out2();
	//�ӿ��п��Զ��塰��Ա������������˵�ǲ��ɱ�ĳ�����
	//��Ϊ�ӿ��еġ���Ա���������Զ���ΪΪpublic static final��
	//����ͨ��������ֱ�ӷ��ʣ�ImplementClass.name
	int value = 0;
	public static final int value2 = 1;
}

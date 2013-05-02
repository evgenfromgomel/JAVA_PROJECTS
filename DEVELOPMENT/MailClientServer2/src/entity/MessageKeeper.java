package entity;

public class MessageKeeper {

	
	public static String MAILS_O = "<mails>";
	public static String MAILS_C = "</mails>";
	
	public static String MAIL_O = "<mail>";
	public static String MAIL_C = "</mail>";
	
	public static String NAME_1 = "<name>Sherlock Holmes</name>";
	public static String NAME_2 = "<name>John Watson</name>";
	public static String NAME_3 = "<name>Mr. Smith</name>";
	public static String NAME_4 = "<name>Leo Maxwell</name>";
	public static String NAME_5 = "<name>David Starr</name>";
	
	public static String SUBJ_1 = "<subj>Be accuracy</subj>";
	public static String SUBJ_2 = "<subj>All okay</subj>";
	public static String SUBJ_3 = "<subj>Letter#1</subj>";
	public static String SUBJ_4 = "<subj>Letter#2</subj>";
	public static String SUBJ_5 = "<subj>Letter#3</subj>";
	
	public static String MESSAGE_1 = "<message>Dear friend, you must check your room. I was hear some stranger sounds from here today.</message>";
	public static String MESSAGE_2 = "<message>Don't worry, Holmes. I fogot tell you that I have got pet. That it making some noises.</message>";
	public static String MESSAGE_3 = "<message>I would like to thank you for the Job interview and the time we spent speaking about the job position in your organization yesterday.</message>";
	public static String MESSAGE_4 = "<message>This is in regards to the job interview yesterday. I have applied for the post of a ‘The Job Position’ with your company.</message>";
	public static String MESSAGE_5 = "<message>I would like to thank you for taking the time to meet with me.I want to express my interest in the job and believe that my work skills.</message>";
	
	public static String RECIVED_1 = "<recived>23/01/2012</recived>";
	public static String RECIVED_2 = "<recived>24/01/2012</recived>";
	public static String RECIVED_3 = "<recived>25/01/2012</recived>";
	public static String RECIVED_4 = "<recived>02/02/2012</recived>";
	public static String RECIVED_5 = "<recived>08/02/2012</recived>";
	
	public static String getMailList(){
		String allList = MAILS_O;
		
		allList += MAIL_O;
		allList += NAME_1;
		allList += SUBJ_1;
		allList += MESSAGE_1;
		allList += RECIVED_1;
		allList += MAIL_C;
		
		allList += MAIL_O;
		allList += NAME_2;
		allList += SUBJ_2;
		allList += MESSAGE_2;
		allList += RECIVED_2;
		allList += MAIL_C;
		
		allList += MAIL_O;
		allList += NAME_3;
		allList += SUBJ_3;
		allList += MESSAGE_3;
		allList += RECIVED_3;
		allList += MAIL_C;
		
		allList += MAIL_O;
		allList += NAME_4;
		allList += SUBJ_4;
		allList += MESSAGE_4;
		allList += RECIVED_4;
		allList += MAIL_C;
		
		allList += MAIL_O;
		allList += NAME_5;
		allList += SUBJ_5;
		allList += MESSAGE_5;
		allList += RECIVED_5;
		allList += MAIL_C;
		
		allList += MAILS_C;
		return allList;
	}
	
		
}

package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Washington Oliveira
 * Classe criada para obter campos de uma string de json,utilizando de Regex
 * Class created in order to handle json string data, using Regex only
 */
public class RegexJson {
	
	private static final String[] regexes = new String[]{
			//Pega todos campos
			//Get all fields in JSON String
			"\"[a-zA-Z-0-9 _]+\"(| ):(| )(\"|)([a-zA-Z-0-9 ]+)(\"|$|)",
			//Pega um campo específico, só precisa dá um replace do atributo #{campo} para o campo que desejar
			//Get the especified field, you must replace the value #{campo} to the value that you what
			"\"#{campo}\"(| ):(| )(\"|)([a-zA-Z-0-9 ]+)(\"|$|)",
			//PEGA LISTA
			//Take all list from JSON string
			"\\[.+]",
			//PEGA LISTA COM O NOME DA VARIÁVEL QUE PEGA A LISTA
			//Take all list from JSON string but with the name of field that contains the list
			"\"[a-zA-Z-0-9 _]+\"( : |:)\\[.+]"};
	
	
	public static final String[] getLists(String strJson){
		String[] ret = null;
		int count = 0;
		
		try{
			
			String regex = regexes[3];
			
			Pattern p = Pattern.compile(regex);
        	Matcher m = p.matcher(strJson);
			
        	while(m.find()){
        		count++;
        		
        		String[] lastArray = ret;
        		ret = new String[count];
        		int i = 0;
        		if(lastArray != null && lastArray.length > 0){
        			
        			for( ;  i < lastArray.length ; i++){
        				
        				ret[i] = lastArray[i];
        				
        			}
        			
        		}
        		ret[i] = strJson.substring(m.start(),m.end());
        		
        	}
        	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		if(ret == null || ret.length <= 0){
			ret = new String[0];
		}
		
		return ret;
	}
	
	public static final String[] getAllFields(String strJson){
		String[] ret = null;
		int count = 0;
		
		try{
			
			String regex = regexes[0];
			
			Pattern p = Pattern.compile(regex);
        	Matcher m = p.matcher(strJson);
			
        	while(m.find()){
        		count++;
        		
        		String[] lastArray = ret;
        		ret = new String[count];
        		int i = 0;
        		if(lastArray != null && lastArray.length > 0){
        			
        			for( ;  i < lastArray.length ; i++){
        				
        				ret[i] = lastArray[i];
        				
        			}
        			
        		}
        		ret[i] = strJson.substring(m.start(),m.end());
        		
        	}
        	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		if(ret == null || ret.length <= 0){
			ret = new String[0];
		}
		
		return ret;
	}
	
	public static final String[] getField(String fieldName,String strJson,String defaultValue){
		String[] ret = null;
		int count = 0;
		
		try{
			
			String regex = regexes[1].replace("#{campo}",fieldName);
			
			Pattern p = Pattern.compile(regex);
        	Matcher m = p.matcher(strJson);
			
        	while(m.find()){
        		count++;
        		
        		String[] lastArray = ret;
        		ret = new String[count];
        		int i = 0;
        		if(lastArray != null && lastArray.length > 0){
        			
        			for( ;  i < lastArray.length ; i++){
        				
        				ret[i] = lastArray[i];
        				
        			}
        			
        		}
        		ret[i] = strJson.substring(m.start(),m.end());
        		
        	}
        	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		if(ret == null || ret.length <= 0){
			ret = new String[]{defaultValue};
		}
		
		return ret;
	}
	

}

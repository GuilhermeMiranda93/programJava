package controller;

import java.util.ArrayList;
import java.util.Collections;

public class Funcoes {

	public int retornoEspacosNecessarios(ArrayList<String> lista)
	{
		int espacosNecessarios = 0;

		Collections.sort(lista);
		
		if(lista.size() > 1){
			
			for(int x=0; x<lista.size()-1; x++)
			{
				String a = lista.get(x);
				String b = lista.get(x+1);
				int z = 0;
				for(int y=0; y<a.length(); y++)
				{
					if(a.charAt(y) != b.charAt(y))
					{
						espacosNecessarios = espacosNecessarios + a.length() - y + b.length() - y;
						break;
					}
					else
					{
						espacosNecessarios = espacosNecessarios + 1;
					}
				}
				if(x>=1){
					z = espacosNecessarios - a.length();
					espacosNecessarios = z;
				}
			}
		}
		
		else{
			espacosNecessarios = lista.get(0).length();
		}
		return espacosNecessarios;
	}
}

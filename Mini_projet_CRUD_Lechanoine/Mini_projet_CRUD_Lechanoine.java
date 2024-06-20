// Importation des librairies
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Mini_projet_CRUD_Lechanoine
{
	public static void main(String[] args)
	{
		List<String[]> lstFilm;
		int            cpt;
		String[]       Film1, Film2, Film3, Film4, Film5 ;
		String         txtUtilisateur;
		String[]       tabFilm;
		Scanner        scanner;
		int            indiceFilmAModifie;
		int            categorieAModifier;

		lstFilm = new ArrayList<String[]>();
		
		// Liste d'exemple
		Film1 = new String[] {"Alien le huitieme passager","SF,Horreur","1979"};
		Film2 = new String[] {"La ligne verte", "Crime, Cinéma de fantasy", "1999"};
		Film3 = new String[] {"Ace Vantura", "Comédie,Film à énigme", "1994"};
		Film4 = new String[] {"Ready player one", "SF,Action", "2018"};
		Film5 = new String[] {"Venom", "SF,Action", "2018"};
		tabFilm = new String[3];
		scanner = new Scanner(System.in);
		lstFilm.add(Film1);
		lstFilm.add(Film2);
		lstFilm.add(Film3);
		lstFilm.add(Film4);
		lstFilm.add(Film5);
		
		// Si on rentre Q fin du programme
		txtUtilisateur = "";
		while (!txtUtilisateur.equals("Q"))
		{
			System.out.print("Saisissez une action (A : Ajouter),(C : Consulter),(M : modifier),(E : effacer),(Q : quitter) : ");

			if (txtUtilisateur.equals(""))
			{
				txtUtilisateur = scanner.nextLine();
			}

			// La partie Ajout
			if (txtUtilisateur.equals("A"))
			{
				cpt = 0;
				while (cpt < tabFilm.length) 
				{
					if (cpt == 0)
					{
						System.out.print("Entrer le nom du film : ");
					}

					if (cpt == 1)
					{
						System.out.print("Entrer le(s) genre(s) : ");
					}

					if (cpt == 2)
					{
						System.out.print("Entrer l'année de sortie du film : ");
					}
						
					tabFilm[cpt] = scanner.nextLine();
					cpt = cpt + 1;
				}

				lstFilm.add(tabFilm);
		
			}
			
			// La partie Consulter
			if (txtUtilisateur.equals("C"))
			{
				cpt = 0;
				while (cpt < lstFilm.size())
				{
					System.out.print(lstFilm.get(cpt)[0] + " | " );
					System.out.print(lstFilm.get(cpt)[1] + " | " );
					System.out.println(lstFilm.get(cpt)[2] + " | " );
					cpt = cpt + 1;
				}
			}

			// La partie Modifier
			if (txtUtilisateur.equals("M"))
			{
				System.out.print("Entrez le nom du film que vous voulez modifier : ");
				txtUtilisateur = scanner.nextLine();

				System.out.print("Entrez la catégorie à modifier (1 : Titre, 2 : Genre, 3 : Annee) : ");
				categorieAModifier = scanner.nextInt();

				// Recherche de l'indice d'une donnée dans le tableau
				cpt = 0;
				indiceFilmAModifie = 1;
				while (cpt < lstFilm.size())
				{
					if (lstFilm.get(cpt)[0].equals(txtUtilisateur))
					{
						indiceFilmAModifie = cpt;
					}
					cpt = cpt + 1;
				}

				System.out.print("Quel est la nouvelle valeur : ");
				txtUtilisateur = scanner.nextLine();

				if (txtUtilisateur.equals(""))
				{
					txtUtilisateur = scanner.nextLine();
				}

				lstFilm.get(indiceFilmAModifie)[categorieAModifier - 1] = txtUtilisateur;
			}

			// La partie Effacer
			if (txtUtilisateur.equals("E"))
			{
				System.out.print("Entrez le nom du film que vous voulez effacer : ");
				txtUtilisateur = scanner.nextLine();

				// Recherche de l'indice d'une donnée dans le tableau
				cpt = 0;
				indiceFilmAModifie = 1;
				while (cpt < lstFilm.size())
				{
					if (lstFilm.get(cpt)[0].equals(txtUtilisateur))
					{
						indiceFilmAModifie = cpt;
					}
					cpt = cpt + 1;
				}

				lstFilm.remove(indiceFilmAModifie);
			}

			if (!txtUtilisateur.equals("Q"))
			{
				txtUtilisateur = "";
			}

		}

		scanner.close();

	}

}
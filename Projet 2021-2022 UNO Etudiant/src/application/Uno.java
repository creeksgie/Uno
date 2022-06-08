package application;
	
import java.util.ArrayList;

import Carte.Carte;
import Carte.CartePasse;
import Carte.CartePlusDeux;
import Carte.CarteSimple;
import Exception.CarteException;
import Exception.JoueurException;
import Exception.PiocheException;
import Exception.TasException;
import Exception.UnoException;
import Joueur.Joueur;
import Partie.Partie;

/**
 * Pour iMac : 
 * Le chemin des modules FX sont là :
 * /Users/dordal/cdt-master/javafx-sdk-11.0.2/lib
 * Il faut ajouter les arguments :
 *  --module-path /Users/dordal/cdt-master/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml
 * et décocher la case ...Xstart.... 
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Uno extends Application {


	private static final int H_CANVAS = 130;
	private static final int L_CANVAS = 400;
	private static final int L_CARTE = 80;
	private static final int ECART = 30;
	private Canvas canSabot;

	private Partie P = new Partie();
	ArrayList<Carte> MainYann = new ArrayList<Carte>();
	ArrayList<Carte> MainCamille = new ArrayList<Carte>();
	ArrayList<Carte> MainIsabelle = new ArrayList<Carte>();
	ArrayList<Carte> MainCharlotte = new ArrayList<Carte>();
	ArrayList<Joueur> TabJoueur = new ArrayList<Joueur>();
	private int tmp = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			P.initialiserInterface();
			P.setNombreJoueur(4);
			
		    Joueur Yann = new Joueur("Yann", 1, MainYann);
		    Joueur Camille = new Joueur("Camille", 2, MainCamille);
		    Joueur Isabelle = new Joueur("Isabelle", 3, MainIsabelle);
		    Joueur Charlotte = new Joueur("Charlotte", 4, MainCharlotte);
		    
		    Carte Vert8 = new CarteSimple(8, "vert");
		    Carte Rouge1 = new CarteSimple(1, "rouge");
		    Carte Jaune6 = new CarteSimple(6, "jaune");
		    Carte Vert2 = new CarteSimple(2, "vert");
		    Carte Bleu2= new CarteSimple(2, "bleu");
		    Carte Jaune4 = new CarteSimple(4, "jaune");
		    Carte Rouge9 = new CarteSimple(9, "rouge");
		    Carte Vert0 = new CarteSimple(0, "vert");
		    Carte Bleu8 = new CarteSimple(8, "bleu");
		    Carte PasseRouge = new CartePasse("rouge");
		    Carte PasseVert = new CartePasse("vert");
		    Carte PasseBleu = new CartePasse("bleu");
		    Carte Bleu1 = new CarteSimple(1, "bleu");
		    Carte Vert2P = new CartePlusDeux("vert");
		    Carte Rouge2P = new CartePlusDeux("rouge");
		    Carte Jaune2P = new CartePlusDeux("jaune");
		    Carte Vert1 = new CarteSimple(1, "vert");
		    
		    MainYann.add(Vert1);
		    MainYann.add(Bleu8);
		    MainYann.add(Jaune6);
		    MainYann.add(Vert2);
		    MainYann.add(PasseRouge);
		    
		    MainCamille.add(Vert2P);
		    MainCamille.add(Jaune4);
		    MainCamille.add(Bleu8);
		    MainCamille.add(Vert0);
		    MainCamille.add(Rouge9);
		    
		    MainIsabelle.add(Rouge1);
		    MainIsabelle.add(PasseVert);
		    MainIsabelle.add(Jaune6);
		    MainIsabelle.add(Rouge2P);
		    MainIsabelle.add(PasseBleu);
		    
		    MainCharlotte.add(Vert8);
		    MainCharlotte.add(PasseVert);
		    MainCharlotte.add(Bleu1);
		    MainCharlotte.add(Bleu2);
		    MainCharlotte.add(Jaune2P);
		    
		    Yann.SetPartie(P);
		    Camille.SetPartie(P);
		    Isabelle.SetPartie(P);
		    Charlotte.SetPartie(P);
		    
		    TabJoueur.add(Yann);
		    TabJoueur.add(Camille);
		    TabJoueur.add(Isabelle);
		    TabJoueur.add(Charlotte);
		    
			VBox joueurNord = initJoueur(Yann);
			root.setTop(joueurNord);
			
			VBox joueurOuest = initJoueur(Camille);
			root.setRight(joueurOuest);

			VBox joueurSud = initJoueur(Isabelle);
			root.setBottom(joueurSud);

			VBox joueurEst = initJoueur(Charlotte);
			root.setLeft(joueurEst);
			
			root.setCenter(initSabot());
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private VBox initJoueur(Joueur J) {
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		
		Label nomNord = initLabelNom(J.getNom());
		//listeCartes = J.getMainJoueur();
		Canvas canMainNord = initMain(J);
		HBox unoNord = initBoutonUno(canMainNord, J);
		vBox.getChildren().addAll(nomNord,canMainNord,unoNord);
		return vBox;
	}


	private HBox initBoutonUno(Canvas canMain,Joueur J) {
		/* Cette partie est sans doute incomplète. Il y a sans doute d'autres actions à 
		 * prévoir que piocher et dire uno !
		 */
		
		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		Button	boutonUno = new Button("Uno !");

		boutonUno.setOnAction(select -> {
			try {
				J.Uno();
			} catch (UnoException e) {
				try {
					P.punitionUno(J);
					dessinerMain(J.getMainJoueur(), canMain);
				} catch (JoueurException | PiocheException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		Button	boutonPioche = new Button("Pioche");

		boutonPioche.setOnAction(select -> {
			System.out.println("Le joueur pioche");
			//System.out.println(J.getMainJoueur());
			try {
				J.Pioche();
				dessinerMain(J.getMainJoueur(), canMain);
				if(P.getTAS(P.Tassize()-1)instanceof CartePlusDeux)
					tmp = 1;
			} catch (PiocheException e) {
				 if(P.getJoueurCourant() != J.getOrdre())
				 {
					 try {
							P.punition(J);
						} catch (JoueurException e1) {
							e1.printStackTrace();
						} catch (PiocheException e1) {
							e1.printStackTrace();
						} catch (UnoException e1) {
							e1.printStackTrace();
						}
				 }
				 else
				System.out.printf("Tu ne peut pas jouer puis piocher");
				dessinerMain(J.getMainJoueur(), canMain);
				dessinerSabot();
			}
			
		});
		
		Button	boutonFin = new Button("Valider");
		
		boutonFin.setOnAction(select -> {
			try {
				J.finTour();
				
			} catch (JoueurException e) {
				e.printStackTrace();
			} catch (UnoException e) {
				try {
					J.setPasse(true);
					P.punitionUno(J);
					dessinerMain(J.getMainJoueur(), canMain);
				} catch (JoueurException | PiocheException e1) {
					e1.printStackTrace();
				}
			}
			if(P.getTAS(P.Tassize()-1)instanceof CartePlusDeux && tmp == 0)
			{
				try {
					TabJoueur.get(P.getJoueurCourant()-1).Encaisser();
					tmp = 1;
				} catch (PiocheException | JoueurException | UnoException e1) {
					e1.printStackTrace();
				}
			}
			else
				tmp = 0;
		});
		
		
		Button	boutonEncaisser = new Button("Encaisser");
		
		boutonEncaisser.setOnAction(select -> {
			tmp = 0;
			dessinerMain(J.getMainJoueur(), canMain);
		});

		hBox.getChildren().addAll(boutonUno,boutonPioche,boutonFin,boutonEncaisser);
		
		return hBox;
	}


	private Label initLabelNom(String nom) {
		Label bidon = new Label("");
		bidon.setFont(new Font("Arial", 30));

		Label lNom = new Label(nom);
		lNom.setFont(new Font("Arial", 30));

		return lNom;
	}
	

	private Canvas initSabot() {
		
		canSabot = new Canvas();

		dessinerSabot();
		
		canSabot.setOnMouseClicked(clic -> { 
			System.out.println("Pioche!");
			/* j'ai prévu l'évènement mais personnellement je ne l'utilise pas. J'utilise le bouton
			 * prévu pour chaque joueur. Faites coimme vous voulez !
			 */
		});

		return canSabot;
	}	
	
	private void dessinerSabot() {
		Image sabot = new Image(getClass().getResourceAsStream("/Sabot.png"));
		Image dos = new Image(getClass().getResourceAsStream("/carte_dos.png"));
		canSabot.setWidth(sabot.getWidth());
		canSabot.setHeight(sabot.getHeight());
		Image carte;
		if(P.getTAS(P.Tassize()-1)instanceof CartePasse)
		{
			CartePasse C = (CartePasse) P.getTAS(P.Tassize()-1);
			carte = new Image(getClass().getResourceAsStream("/carte_Passe_"+C.getCouleur()+".png"));
		}
		else
		{
			if(P.getTAS(P.Tassize()-1)instanceof CartePlusDeux)
			{
				CartePlusDeux C = (CartePlusDeux) P.getTAS(P.Tassize()-1);
				carte = new Image(getClass().getResourceAsStream("/carte_Plus2_"+C.getCouleur()+".png"));
			}
			else
			{
				CarteSimple C = (CarteSimple) P.getTAS(P.Tassize()-1);
				carte = new Image(getClass().getResourceAsStream("/carte_"+C.getNumero()+"_"+C.getCouleur()+".png"));
			}
		}
		canSabot.getGraphicsContext2D().drawImage(sabot,0,0);
		canSabot.getGraphicsContext2D().drawImage(carte,25,20);
		canSabot.getGraphicsContext2D().drawImage(dos,124,20);
	}


	private Canvas initMain(Joueur J) {
		Canvas canMain = new Canvas(L_CANVAS,H_CANVAS);

		dessinerMain(J.getMainJoueur(), canMain);
		
		
		canMain.setOnMouseClicked(clic -> { 
			int x = (int) clic.getX();
			int nbCartes = J.getMainJoueur().size();
			int lMain = L_CARTE+((nbCartes-1)*ECART);
			int pad = (L_CANVAS-lMain) / 2;

			if (x>=pad && x<=pad+lMain) {
				int num = (int) ((x-pad) / ECART);
				num = Math.min(nbCartes-1, num);
				/*System.out.println("Le joueur a selectionner la carte "+num);
				System.out.println("cette carte est le " + J.getMainJoueur().get(num));*/
				
				if(P.getJoueurCourant() == J.getOrdre())
				{
					try {
						J.JoueUneCarte(J.getMainJoueur().get(num));
					} catch (CarteException e) {
						try {
							P.punition(J);
						} catch (JoueurException e1) {
							e1.printStackTrace();
						} catch (PiocheException e1) {
							e1.printStackTrace();
						} catch (UnoException e1) {
							e1.printStackTrace();
						}
					} catch (JoueurException e) {
						e.printStackTrace();
					} catch (TasException e) {
						e.printStackTrace();
					}
					dessinerMain(J.getMainJoueur(), canMain);
					dessinerSabot();
				}
				else
				{
					try {
						P.punition(J);
					} catch (JoueurException e) {
						e.printStackTrace();
					} catch (PiocheException e) {
						e.printStackTrace();
					} catch (UnoException e) {
						e.printStackTrace();
					}
					dessinerMain(J.getMainJoueur(), canMain);
					dessinerSabot();
				}
			}
		});
		
		return canMain;
	}


	private void dessinerMain(ArrayList<Carte> arrayList, Canvas canvas) {
		/* liste est une liste de chaines de car. Mais vous devriez sans doute utiliser
		 * vos propres classes, pas des String !
		 */
		
		
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		int nbCartes = arrayList.size();
		int lMain = L_CARTE+((nbCartes-1)*ECART);
		int pad = (L_CANVAS-lMain) / 2;
		
		for (int i=0; i<nbCartes; i++) {
			if(arrayList.get(i)instanceof CarteSimple)
			{
				CarteSimple C = (CarteSimple) arrayList.get(i);
				Image carte = new Image(getClass().getResourceAsStream("/carte_"+C.getNumero()+"_"+C.getCouleur()+".png"));
				canvas.getGraphicsContext2D().drawImage(carte,pad+i*ECART,0);
			}
			if(arrayList.get(i)instanceof CartePasse)
			{
				CartePasse C = (CartePasse) arrayList.get(i);
				Image carte = new Image(getClass().getResourceAsStream("/carte_Passe_"+C.getCouleur()+".png"));
				canvas.getGraphicsContext2D().drawImage(carte,pad+i*ECART,0);
			}
			if(arrayList.get(i)instanceof CartePlusDeux)
			{
				CartePlusDeux C = (CartePlusDeux) arrayList.get(i);
				Image carte = new Image(getClass().getResourceAsStream("/carte_Plus2_"+C.getCouleur()+".png"));
				canvas.getGraphicsContext2D().drawImage(carte,pad+i*ECART,0);
			}
		}
	}
	



	public static void main(String[] args) {
		launch(args);
	}
}

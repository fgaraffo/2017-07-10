package it.polito.tdp.artsmia.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model() ;
		
		m.creaGrafo();
		
		/*
		List<ArtObject> list = m.getArtObjects() ;
		for( ArtObject ao : list) {
			int dimCC = m.calcolaDimensioneCC(ao.getId()) ;
			System.out.format("Vertice %d, dimensione %d\n", ao.getId(), dimCC);
		}
		*/
		
		List<ArtObject> best1 = m.camminoMassimo(5342,3) ;

	}

}

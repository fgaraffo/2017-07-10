package it.polito.tdp.artsmia.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {

	private List <ArtObject> artObjects;
	private Graph <ArtObject, DefaultWeightedEdge> graph;
	List <ArtObject> best = null;
	
		
	/**
	 * Popola la lista artobjects (leggendo dal DB) e crea il grafo.
	 */
	public void creaGrafo() {
	
		// leggi lista oggetti dal DB
		ArtsmiaDAO dao = new ArtsmiaDAO();
		this.artObjects = dao.listObjects();
		
		// Crea il grafo
		this.graph = new SimpleWeightedGraph <> (DefaultWeightedEdge.class);
		
		// Aggiungi i vertici
/*		for (ArtObject ao : this.artObjects)
		{
			this.graph.addVertex(ao);
		}
*/		
		Graphs.addAllVertices(this.graph, this.artObjects);
		
		// Aggiungi gli archi (con il loro peso)
		for (ArtObject ao : this.artObjects)
		{
			List <ArtObjectAndCount> connessi = dao.listArtObjectAndCount(ao);
			for (ArtObjectAndCount c : connessi)
			{
				ArtObject dest = new ArtObject(c.getArtObjectId(), null, null, null, 0, null, null, null, null, null, 0, null, null, null, null, null);
				Graphs.addEdge(this.graph, ao, dest, c.getCount());
			}
		}
	
		/*VERSIONE 1: poco efficiente **
		for(ArtObject aop : this.artObjects)
		{
			for(ArtObject aoa : this.artObjects)
			{
				if (!aop.equals(aoa) && aop.getId()<aoa.getId()) // Escludo coppie (ao, ao) per escludere i loop
				{
					int peso = exhibitionComuni(aop, aoa);
								
					if (peso!=0)
					{
						// Aggiungi un arco con il peso
//						DefaultWeightedEdge e = this.graph.addEdge(aop, aoa);
//						graph.setEdgeWeight(e, peso);
						System.out.format("(%d, %d) peso %d\n",aop.getId(),aoa.getId(), peso);
						Graphs.addEdge(this.graph, aop, aoa, peso);	
					}
				}
			}
		}
		*/
	}


	private int exhibitionComuni(ArtObject aop, ArtObject aoa) {
		ArtsmiaDAO dao = new ArtsmiaDAO();
		int comuni = dao.contaExhibitionComuni(aop, aoa);
		
		return comuni;
	}


	public int getGraphNumEdges() {
		return this.graph.edgeSet().size();
	}

	public int getGraphNumVertices() {
		return this.graph.vertexSet().size();
	}


	public boolean isObjIdValid(int idObj) {
		
		if (this.artObjects==null)
			throw new NullPointerException("Prima crea il grafo");
		
		for (ArtObject ao : artObjects)
		{
			if (ao.getId()==idObj)
				return true;
		}
		return false;
	}


	public int calcolaDimensioneCC(int idObj) {
		// Trova il vertice di partenza
		ArtObject start = trovaVertice(idObj);

		// Visita il grafo
		Set <ArtObject> visitati = new HashSet<>();
		DepthFirstIterator<ArtObject, DefaultWeightedEdge> dfv = new DepthFirstIterator<>(this.graph, start);
		while (dfv.hasNext())
		{
			visitati.add(dfv.next());
		}
		// Conta gli elementi
		return visitati.size();
	}
	
	public List<ArtObject> getArtObjects() {
		return artObjects;
	}
	
	public List <ArtObject> camminoMassimo (int startId, int LUN)
	{
		// Trova il vertice di partenza
		ArtObject start = trovaVertice(startId);
		
		List <ArtObject> parziale = new ArrayList<>();
		parziale.add(start);
		best = parziale;
		
		cerca(parziale, 1, LUN);
		
		return best;
	}
	
	// Soluzione punto 2
	public void cerca (List <ArtObject> parziale, int livello, int LUN)
	{
		if (livello==LUN) {
			// Caso terminale
			if (peso(parziale)>peso(best))
			{
				best = new ArrayList<>(parziale);
				System.out.println(parziale);
			}
			return;
		}
			
		// Trova i vertici adiacenti all'ultimo
		ArtObject ultimo = parziale.get(parziale.size()-1);
		List <ArtObject> adiacenti = Graphs.neighborListOf(this.graph, ultimo);
		
		for (ArtObject prova : adiacenti)
		{
			if (!parziale.contains(prova) && prova.getClassification() != null &&
				prova.getClassification().equals(parziale.get(0).getClassification()))
			{
				parziale.add(prova);
				cerca(parziale, livello+1, LUN);
				parziale.remove(parziale.size()-1);
			}
		}
		
	}


	private int peso(List<ArtObject> parziale) {
		int peso = 0;
		for (int i=0;i<parziale.size()-1;i++)
		{
			DefaultWeightedEdge e = graph.getEdge(parziale.get(i), parziale.get(i+1));
			int pesoarco = (int) graph.getEdgeWeight(e);
			peso+=pesoarco;
		}
		return peso;
	}
	
	private ArtObject trovaVertice (int idObj)
	{
		ArtObject start = null;
		for (ArtObject ao : this.artObjects)
		{
			if (ao.getId()==idObj)
			{
				start = ao;
				break;
			}
		}
		if (start==null)
			throw new IllegalArgumentException("Vertice "+idObj+" non esistente.");
		return start;
	}
}

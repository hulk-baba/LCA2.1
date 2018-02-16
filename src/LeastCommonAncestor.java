import java.io.StringReader;
import java.util.Set;
import java.io.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;
import org.jgrapht.io.DOTImporter;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.GraphImporter;
import org.jgrapht.io.VertexProvider;
import org.jgrapht.alg.*;


public class LeastCommonAncestor {
	public static String readFile(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } catch(Exception e){
        	e.getMessage();
        }
        finally {
            br.close();
        }
    	return "";
	}
	
	public static Set<String> allLcas(String fileName, String person1, String person2 ){
		try {
            //reading contents of dot file as string
       	 	String input = readFile(fileName);
            //Parsing graph using DOTImporter class
        	VertexProvider<String> vp = (a, b) -> a;
            EdgeProvider<String, DefaultEdge> ep = (f, t, l, a) -> new DefaultEdge();
            GraphImporter<String, DefaultEdge> importer = new DOTImporter<String, DefaultEdge>(vp, ep);
            DirectedPseudograph<String, DefaultEdge> graph = new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);
            importer.importGraph(graph, new StringReader(input));
            //Finding all LCAJo using findLcaS from NaiveLcaFinder class, re used with some modifications
            NaiveLcaFinder<String, DefaultEdge> graphFinder = new NaiveLcaFinder<>(graph);
            //accessing command line arguments
           
            Set<String> graphAns = graphFinder.findLcas( person1 , person2);
            return graphAns;
            
        } catch (Exception e) {
                e.getMessage();
        }
		return null;
	}
	public static void main(String args[]){
        
		String fileName = "/home/atul/JGRAPHT/demo4.dot";
		String person1 = args[0];
		String person2 = args[1];
		Set<String>graphAns = allLcas(fileName, person1 , person2);
		if(!graphAns.isEmpty()){
			for (String lca : graphAns) {
		        System.out.print(lca + " ");
		    }
		}
		
	}
	
}
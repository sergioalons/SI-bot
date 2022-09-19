import java.io.*;
import java.util.*;
/**
 * This class is a dummy chat bot
 */
class MyBot {

    HashMap<String, String> knowledge = new HashMap<String, String>();

    /**
     * This is a default constructor.
     */
    public MyBot() {
            if (1==2) {

                knowledge.put("Hello", "Hi yo");
        knowledge.put("how are you?", "Great! And you?");
        knowledge.put("what time is it", "Look at your watch!");
    }
            else{
                try{
                    File toRead=new File("cerebro.txt");
                    FileInputStream fis=new FileInputStream(toRead);

                    Scanner sc=new Scanner(fis);

                    HashMap<String,String> mapInFile= new HashMap<String,String>();

                    //read data from file line by line:
                    String currentLine;
                    while(sc.hasNextLine()){
                        currentLine=sc.nextLine();
                        //now tokenize the currentLine:
                        StringTokenizer st=new StringTokenizer(currentLine,"=",false);
                        //put tokens ot currentLine in map
                        mapInFile.put(st.nextToken(),st.nextToken());
                    }
                    fis.close();

                    //print All data in MAP
                    //for(Map.Entry<String,String> m :mapInFile.entrySet()){
                     //   System.out.println(m.getKey()+" : "+m.getValue());
                    //}
                    knowledge = mapInFile;
                }catch(Exception e){}

        }
        knowledge.put("Temario de la asignatura", "1. Introducción a la Teoría General de Sistemas y al Pensamiento Sistémico\n" +
                "1.1. Pensamiento Sistémico\n" +
                "1.2. Teoría General de Sistemas\n" +
                "1.3. Visión sistémica para la resolución de problemas\n" +
                "2. Introducción a la Inteligencia Artificial\n" +
                "2.1. Historia y definición. Test de Turing. TTT\n" +
                "2.2. Dato, Información, Conocimiento\n" +
                "2.3. Representación del Conocimiento\n" +
                "2.4. Exploración en Espacios de Estados\n" +
                "2.5. Reconocimiento de Patrones\n" +
                "2.6. Aprendizaje\n" +
                "3. Percepción Computacional\n" +
                "3.1. Introducción a la Percepción Computacional\n" +
                "3.2. Formación de imágenes digitales\n" +
                "3.3. Preproceso\n" +
                "3.4. Segmentación\n" +
                "3.5. Descripción\n" +
                "3.6. Reconocimiento de objetos\n" +
                "4. Realidad: física, aumentada, virtual y mixta\n" +
                "5. Entornos virtuales en 3D para la experimentación en Sistemas Inteligentes\n" +
                "5.1. Estándares, Herramientas y Lenguajes\n" +
                "5.2. Esquema de un Sistema Inteligente en un entorno virtual en 3D\n" +
                "5.3. Plataformas virtuales: Open Sim y Second Life\n" +
                "5.4. Unity 3D\n" +
                "6. Lógica Borrosa. Representación\n" +
                "6.1. Teoría de Conjuntos Borrosos\n" +
                "6.2. Lógica Borrosa\n" +
                "6.3. Control Borroso\n" +
                "6.4. Representación del conocimiento mediante Lógica Borrosa\n" +
                "7. Computación Evolutiva. Aprendizaje\n" +
                "7.1. Introducción a la Computación Evolutiva\n" +
                "7.2. Esquema General de un Algoritmo Evolutivo\n" +
                "7.3. Tipos de Algoritmos Evolutivos\n" +
                "7.4. Elementos de un Algoritmo Evolutivo\n" +
                "7.5. Aprendizaje mediante Computación Evolutiva. Comportamiento típico de un Algoritmo Evolutivo");
    }
    public void guardar (HashMap<String,String> map){
        try{
            File cerebro=new File("cerebro.txt");
            FileOutputStream fos=new FileOutputStream(cerebro);
            PrintWriter pw=new PrintWriter(fos);

            for(Map.Entry<String,String> m :map.entrySet()){
                pw.println(m.getKey()+"="+m.getValue());
            }

            pw.flush();
            pw.close();
            fos.close();
        }catch(Exception e){}
    }

    public void answer(String question) {
        Set<String> keys = knowledge.keySet();
        for (String key : keys) {
            String lowerKey = key.toLowerCase();
            String lowerQuestion = question.toLowerCase();
            if (lowerKey.contains(lowerQuestion)) {
                System.out.println("Bot: " + knowledge.get(key));
                return;//break
            }
        }
        trainMe(question);
    }

    public void trainMe(String question) {
        System.out.println("Bot: Sorry, Im dumb! How should I reply");
        System.out.print("User suggestion: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        knowledge.put(question, userInput);
        guardar(knowledge);
    }
}

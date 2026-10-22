package com.spring.ai.firstproject;
import com.spring.ai.firstproject.service.DataLoader;
import com.spring.ai.firstproject.service.DataTransformer;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FirstProjectApplicationTests {

	@Test
	void contextLoads() {
	}

    @Autowired
     private DataLoader dataLoader;
    @Autowired
    private DataTransformer dataTransformer;

    @Autowired
    private VectorStore vectorStore;

    @Test
    void testJsonDataLoader(){
        var documents = dataLoader.loadDocumentsFromJson();
        System.out.println(documents.size());
        documents.forEach(item->{
            System.out.println(item);
        });
    }

    @Test
    void testPdfDataLoader(){
//        1. Read The Data
        List<Document> documents = dataLoader.loadDocumentsFromPdf();
        System.out.println(documents.size());
        documents.forEach(item->{
            System.out.println(item);
            System.out.println("----------------------");
        });
        System.out.println("Read __ now going to transform");
//        2. Transform The Data
        var transformedDocument = dataTransformer.transform(documents);
        System.out.println(transformedDocument.size());

//        3. Write the data into vector Database
            vectorStore.add(transformedDocument);
        System.out.println("Done");
    }

}

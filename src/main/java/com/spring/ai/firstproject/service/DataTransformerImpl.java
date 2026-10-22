
package com.spring.ai.firstproject.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTransformerImpl implements DataTransformer {

    @Override
    public List<Document> transform(List<Document> document) {

        TokenTextSplitter splitter =
                TokenTextSplitter.builder()
                        .withChunkSize(300)
                        .withMinChunkLengthToEmbed(400)
                        .withMinChunkLengthToEmbed(10)
                        .withMaxNumChunks(5000)
                        .withKeepSeparator(true)
                        .build();

        return splitter.transform(document);
    }
}

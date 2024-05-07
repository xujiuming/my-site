package com.ming.service;

import lombok.extern.slf4j.Slf4j;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.text.TextContentRenderer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MarkdownParseService implements CommandLineRunner {


    private static Parser parser;
    private static HtmlRenderer htmlRenderer;
    private static TextContentRenderer textContentRenderer;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        List<Extension> extensions = List.of(TablesExtension.create());
        parser = Parser.builder().extensions(extensions).build();
        htmlRenderer = HtmlRenderer.builder()
                //设置解析节点增加属性
                .attributeProviderFactory(attributeProviderContext -> (node, s, attr) -> {
                    if (node instanceof Image) {
                        attr.put("style", "font: red");
                    }
                    if (node instanceof Link) {

                    }
                })
                .extensions(extensions).build();
        textContentRenderer = TextContentRenderer.builder().build();
    }

    /**
     * markdown 转换为html
     *
     * @param content markdown 内容
     * @return String html
     * @author ming
     * @date 2022-01-19 11:44:05
     */
    public String parseHtml(String content) {
        Node document = parser.parse(content);
        return htmlRenderer.render(document);
    }

    public String parseText(String content) {
        Node document = parser.parse(content);
        return textContentRenderer.render(document);
    }
}

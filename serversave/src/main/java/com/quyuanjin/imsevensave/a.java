package com.quyuanjin.imsevensave;

public class a {
    public static void main(String[] args)
    {
        //说明: 将文章中英文下输入的句号 替换 成中文下输入的句号
        String article="0.467\n" +
                "0.748\n" +
                "0.802\n" +
                "0.77\n" +
                "0.839\n" +
                "0.894\n" +
                "0.798\n" +
                "0.855\n" +
                "0.884\n" +
                "0.878\n" +
                "0.877\n" +
                "0.894\n" +
                "0.879\n" +
                "0.897\n" +
                "0.908\n" +
                "0.894\n" +
                "0.907\n" +
                "0.813\n" +
                "0.886\n" +
                "0.874\n" +
                "0.907\n" +
                "0.917\n" +
                "0.903\n" +
                "0.895\n" +
                "0.889\n" +
                "0.884\n" +
                "0.918\n" +
                "0.917\n" +
                "0.879\n" +
                "0.897\n" +
                "0.876\n" +
                "0.879\n" +
                "0.901\n" +
                "0.892\n" +
                "0.91\n" +
                "0.893\n" +
                "0.919\n" +
                "0.925\n" +
                "0.9\n" +
                "0.887\n" +
                "0.914\n" +
                "0.924\n" +
                "0.931\n" +
                "0.893\n" +
                "0.926\n" +
                "0.919\n" +
                "0.941\n" +
                "0.935\n" +
                "0.93\n" +
                "0.924\n" +
                "0.919\n" +
                "0.924\n" +
                "0.918\n" +
                "0.941\n" +
                "0.895\n" +
                "0.924\n" +
                "0.917\n" +
                "0.915\n" +
                "0.93\n" +
                "0.934\n" +
                "0.95\n" +
                "0.934\n" +
                "0.945\n" +
                "0.953\n" +
                "0.889\n" +
                "0.903\n" +
                "0.914\n" +
                "0.923\n" +
                "0.916\n" +
                "0.931\n" +
                "0.916\n" +
                "0.886\n" +
                "0.935\n" +
                "0.94\n" +
                "0.941\n" +
                "0.935\n" +
                "0.952\n" +
                "0.937\n" +
                "0.931\n" +
                "0.957\n" +
                "0.942\n" +
                "0.941\n" +
                "0.932\n" +
                "0.939\n" +
                "0.922\n" +
                "0.96\n" +
                "0.952\n" +
                "0.927\n" +
                "0.901\n" +
                "0.945\n" +
                "0.941\n" +
                "0.957\n" +
                "0.938\n" +
                "0.947\n" +
                "0.91\n" +
                "0.891\n" +
                "0.963\n" +
                "0.942\n" +
                "0.916\n" +
                "0.902\n";
        System.out.println(article);
        article=article.replace('\n',',');
        System.out.println(article);


    }
}
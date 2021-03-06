package com.liangyou.model.wechatModel.message.outmsg;

import java.util.ArrayList;
import java.util.List;

import com.liangyou.model.wechatModel.message.inmsg.InMsg;
/**
	回复图文消息
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[news]]></MsgType>
			<ArticleCount>2</ArticleCount>
			<Articles>
				<item>
					<Title><![CDATA[title1]]></Title> 
					<Description><![CDATA[description1]]></Description>
					<PicUrl><![CDATA[picurl]]></PicUrl>
					<Url><![CDATA[url]]></Url>
				</item>
				
				<item>
					<Title><![CDATA[title]]></Title>
					<Description><![CDATA[description]]></Description>
					<PicUrl><![CDATA[picurl]]></PicUrl>
					<Url><![CDATA[url]]></Url>
				</item>
			</Articles>
	</xml> 
 */
public class OutNewsMsg extends OutMsg {
	
	private List<News> articles = new ArrayList<News>();
	
	public OutNewsMsg() {
		this.msgType = "news";
	}
	
	public OutNewsMsg(InMsg inMsg) {
		super(inMsg);
		this.msgType = "news";
	}
	
	@Override
	protected void subXml(StringBuilder sb) {
		sb.append("<ArticleCount>").append(getArticleCount()).append("</ArticleCount>\n");
		sb.append("<Articles>\n");
		for (News x : articles) {
			sb.append("<item>\n");
			
			sb.append("<Title><![CDATA[").append(nullToBlank(x.getTitle())).append("]]></Title>\n");
			sb.append("<Description><![CDATA[").append(nullToBlank(x.getDescription())).append("]]></Description>\n");
			sb.append("<PicUrl><![CDATA[").append(nullToBlank(x.getPicUrl())).append("]]></PicUrl>\n");
			sb.append("<Url><![CDATA[").append(nullToBlank(x.getUrl())).append("]]></Url>\n");
			
			sb.append("</item>\n");
		}
		sb.append("</Articles>\n");
	}
	
	public Integer getArticleCount() {
		return articles.size();
	}
	
	public List<News> getArticles() {
		return articles;
	}
	
	public void setArticles(List<News> articles) {
		if (articles != null)
			this.articles = articles;
	}
	
	public OutNewsMsg addNews(List<News> articles) {
		if (articles != null)
			this.articles.addAll(articles);
		return this;
	}
	
	public OutNewsMsg addNews(String title, String description, String picUrl, String url) {
		this.articles.add(new News(title, description, picUrl, url));
		return this;
	}
	
	public OutNewsMsg addNews(News news) {
		this.articles.add(news);
		return this;
	}

}









package com.xtd.ybls.shiro;

import java.io.IOException;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.jagregory.shiro.freemarker.ShiroTags;

import freemarker.template.TemplateException;

/**
 * @author 冯瑞宁
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {

	/**
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Override
	public void afterPropertiesSet() throws IOException, TemplateException {
		
		super.afterPropertiesSet();
		this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
	}

}

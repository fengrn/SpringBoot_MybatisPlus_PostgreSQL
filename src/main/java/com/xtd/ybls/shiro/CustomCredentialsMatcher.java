package com.xtd.ybls.shiro;

import com.xtd.ybls.util.Encrypt;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;


/**
 * @author 冯瑞宁
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	/**
	 * 密码比较的方法 token代表用户在界面输入的用户名和密码，info代码从数据中得到的加密数据
	 * @param token
	 * @param info
	 * @return
	 */
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		// 向下转型
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 将用户在界面输入的原始密码加密
		Object pwd = Encrypt.md5(new String(upToken.getPassword()), upToken.getUsername());
		// 取出数据库中加密的密码
		Object dbPwd = info.getCredentials();
		return this.equals(pwd, dbPwd);

	}
}

package mojo;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import service.GeneratorConfigService;

/**
 * 
 * @Description: maven代码生成插件入口类
 * @author yanjinyin
 * @date 2017年8月8日 下午10:59:08
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class GenerateMojo extends AbstractMojo {

	/**
	 * Maven内置变量说明： •${basedir} 项目根目录 •${project.build.directory}构建目录，缺省为target
	 * •${project.build.outputDirectory} 构建过程输出目录，缺省为target/classes
	 * •${project.build.finalName}
	 * 产出物名称，缺省为${project.artifactId}-${project.version} •${project.packaging}
	 * 打包类型，缺省为jar •${project.xxx} 当前pom文件的任意节点的内容
	 */
	@Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
	private File outputDirectory;

	/**
	 * 获取配置文件路径
	 */
	@Parameter(property = "configXmlPath")
	private String configXmlPath;

	/**
	 * 
	 * @Description: 插件入口方法
	 * @author yanjinyin
	 * @date 2017年8月8日 下午11:15:16
	 */
	public void execute() throws MojoExecutionException {
		System.out.println(configXmlPath);
		// 如果用户未配置配置文件路径，采用默认路径
		//根据generatorConfig.xml得到参数
		GeneratorConfigService.setGeneratorConfigByFile(configXmlPath);
		//根据表信息读取数据库对应数据，得到其相应待生成的数据
		//根据待生成的表数据，生成模板数据
	}
	

}

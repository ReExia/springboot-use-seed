package ${packageName};

import javax.persistence.Id;
import javax.persistence.Table;
<#if importSet?exists>
    <#list importSet as class>
import class;
    </#list>
</#if>

/**
*  Author : ${author}
*  CreateDate: ${currentDate}
*/
@Table(name = "${tableName}")
public class ${entityName} {



}

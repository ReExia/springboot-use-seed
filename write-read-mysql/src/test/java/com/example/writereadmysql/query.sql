SELECT
	driver_id,
	phone,
	driver_name,
	examine_status
FROM
	driver_card_info
WHERE
	examine_status = 2
GROUP BY
	driver_id
HAVING
	COUNT(*) > 1

96884


SELECT
	count(1)
FROM
	car_biz_driver_info_detail
WHERE
	ext2 = 1

128911


SELECT
	count(1)
FROM
	car_biz_driver_info_detail
WHERE
	ext3 = 3
114043


北京司机
17178



排除北京的
SELECT
	count(1)
FROM
	(
		SELECT
			count(1)
		FROM
			driver_card_info
		WHERE
			examine_status = 2
		AND service_city_id != 44
		GROUP BY
			driver_id
		HAVING
			COUNT(*) > 1
	)
as tmp

96872   两个证件及以上


SELECT
	count(1)
FROM
	car_biz_driver_info_detail as a
LEFT JOIN
	car_biz_driver_info as b ON a.driver_id = b.driver_id
WHERE
	ext3 = 3
AND
	b.service_city != 44
96873



SELECT
	count(1)
FROM
	(
		SELECT
			count(1)
		FROM
			driver_card_info
		WHERE
			examine_status = 2
		AND service_city_id != 44
		GROUP BY
			driver_id
		HAVING
			COUNT(*) > 1
	)
as tmp
96069

SELECT
	count(1)
FROM
	car_biz_driver_info_detail as a
LEFT JOIN
	car_biz_driver_info as b ON a.driver_id = b.driver_id
WHERE
	a.ext3 = 3
AND
	b.service_city != 44

94712

测试人员id
308793
43867
153931
2336
772657


870109 粤BDJ1969 该司机换过车牌,换完车牌又有了一个车证(历史遗留),有一个车证是程序导入

driver_card_info
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
`examine_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '审核时间',
examine_time 预计是代码中没有加更新时间,所以与update_time不一致

945446 在26日有一次解绑车辆(司机有重复证件需要修复)

962110 (司机有重复证件需要修复)

1047120 25日有一次绑定车辆(司机有重复证件需要修复)

(司机有重复证件需要修复)证件重复上传原因
同步加盟司机网约车证件DriverVerifyServiceImpl.syncDoubleCardInfo,DriverPassRuleService.passDriverType
1086846
1087010
1088792
1087010
1089952
1091084
1091456
1091492
1091618
1095220
1096132
1096304
1098112
1098390
1099924
1100186
1100282
1100954

数据有时不一致原因
司机解绑,绑定车牌,审核等操作

证件还有重复的问题
排除北京司机后不一致原因
1.目前找到一条程序导入的司机证件,有重复证件
2.同步加盟司机网约车证件


SELECT
	count(1)
FROM
	(
		SELECT
			count(1)
		FROM
			driver_card_info
		WHERE
			examine_status = 2
		AND service_city_id != 44
		AND update_time < "2019-02-25 12:00:00"
		GROUP BY
			driver_id
		HAVING
			COUNT(*) > 1
	)
as tmp
96280

SELECT
	count(1)
FROM
	(
		SELECT
			count(1)
		FROM
			driver_card_info
		WHERE
			examine_status = 2
		AND service_city_id != 44
		AND update_time < "2019-02-25 12:00:00"
		AND car_person_type in(1,2)
		GROUP BY
			driver_id
		HAVING
			COUNT(*) > 1
	)
as tmp
96279

SELECT
	count(1)
FROM
	car_biz_driver_info_detail as a
LEFT JOIN
	car_biz_driver_info as b ON a.driver_id = b.driver_id
WHERE
	a.ext3 = 3
AND
	b.service_city != 44
AND
	a.update_date < "2019-02-25 12:00:00"
95047

不能按时间卡,因为
1.examine_time 要审核才能更新时间
2.create_time  创建时候还未审核
3.update_time  更新时候还未审核

未审核就没触发合规





134473 历史遗留问题

182282 邯郸的司机,双证合规,但是没有证件

driver_id =



按更新时间筛选会有差异

因为有的司机重新上传的双证,证件状态变为了已更新
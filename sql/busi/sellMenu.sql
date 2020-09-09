-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('销售信息', '3', '1', 'sell', 'system/sell/index', 1, 'C', '0', '0', 'system:sell:list', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '销售信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('销售信息查询', @parentId, '1',  '#', '', 1,  'F', '0',  '0', 'system:sell:query',        '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('销售信息新增', @parentId, '2',  '#', '', 1,  'F', '0',  '0', 'system:sell:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('销售信息修改', @parentId, '3',  '#', '', 1,  'F', '0',  '0', 'system:sell:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('销售信息删除', @parentId, '4',  '#', '', 1,  'F', '0',  '0', 'system:sell:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('销售信息导出', @parentId, '5',  '#', '', 1,  'F', '0',  '0', 'system:sell:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
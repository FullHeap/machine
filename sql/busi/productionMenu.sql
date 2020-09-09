-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息', '3', '1', 'production', 'system/production/index', 1, 'C', '0', '0', 'system:production:list', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '产品信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息查询', @parentId, '1',  '#', '', 1,  'F', '0',  '0', 'system:production:query',        '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息新增', @parentId, '2',  '#', '', 1,  'F', '0',  '0', 'system:production:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息修改', @parentId, '3',  '#', '', 1,  'F', '0',  '0', 'system:production:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息删除', @parentId, '4',  '#', '', 1,  'F', '0',  '0', 'system:production:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息导出', @parentId, '5',  '#', '', 1,  'F', '0',  '0', 'system:production:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
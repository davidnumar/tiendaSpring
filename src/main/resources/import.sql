INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ('Jose','Sanchez Lopez','hombre',651212);
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ('Maria','Ramos Antilla','mujer',365353);
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ('Daniel','Perez Pico','hombre',77777);
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ('Ana','Carrillo Juanes','mujer',4566445);
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ('Pedro','Castillo_Mortero','hombre',464564);
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ('Pedrooooo','Castillo_Morterooooo','hombreee',464564);

INSERT INTO productos(nombre,descripcion,precio,existencias) VALUES ('Nintendo switch','Consola portatil y conectable tv',300,5000);
INSERT INTO productos(nombre,descripcion,precio,existencias) VALUES ('Play Station 5','Consola de alto rendimiento conectable',500,10);
INSERT INTO productos(nombre,descripcion,precio,existencias) VALUES ('Xbox One','Consola conectable tv',280,10000);
INSERT INTO productos(nombre,descripcion,precio,existencias) VALUES ('MSI gaming pc','Portatil gaming',200,5000);
INSERT INTO productos(nombre,descripcion,precio,existencias) VALUES ('Nintendo Wii','Consola conectable tv vintage',100,100);
INSERT INTO productos(nombre,descripcion,precio,existencias) VALUES ('Nintendo Wiiiiiiiiii','Consola conectable tv vintage',100,100);

#INSERT INTO ventas(cantidad,iva,subtotal,total,cliente_numero_cliente) VALUES (5,21,2000,2002,1);
#INSERT INTO ventas(cantidad,iva,subtotal,total,cliente_numero_cliente) VALUES (2,21,400,422,2);
#INSERT INTO ventas(cantidad,iva,subtotal,total,cliente_numero_cliente) VALUES (1,21,500,600,3);
INSERT INTO ventas(cantidad,iva,subtotal,total,cliente_numero_cliente) VALUES (3,21,600.5,756.9,4);
INSERT INTO ventas(cantidad,iva,subtotal,total,cliente_numero_cliente) VALUES (2,21,390.55,500,5);

INSERT INTO ventas_productos(venta_folio,productos_clave) VALUES (1,1);
INSERT INTO ventas_productos(venta_folio,productos_clave) VALUES (1,2);
INSERT INTO ventas_productos(venta_folio,productos_clave) VALUES (1,3);
import React, { useState } from 'react';
import AddForm from "../../components/Patient/AddForm";
import { Row, Col, Table, Card, CardTitle, CardBody } from "reactstrap";

const Forms = () => {

  return (
      <Row>
        <Col lg="12">
          <AddForm></AddForm>
        </Col>
      </Row>
  );
};

export default Forms;

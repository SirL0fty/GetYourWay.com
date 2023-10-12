import React, { useState } from "react";

const CoordinateInput = ({ label, onCoordinateChange }) => (
  <div className="form-group">
    <label>{label}</label>
    <div className="input-icon">
      <input
        type="text"
        className="input"
        placeholder={`${label} (latitude, longitude)`}
        onChange={(e) => onCoordinateChange(e.target.value)}
      />
    </div>
  </div>
);

export default CoordinateInput;

import React from 'react';
import { shallow } from 'enzyme';
import ScienceFiction from './ScienceFiction';

describe('<ScienceFiction />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<ScienceFiction />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});

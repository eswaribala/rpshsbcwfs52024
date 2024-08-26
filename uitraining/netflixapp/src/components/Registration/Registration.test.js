import React from 'react';
import { shallow } from 'enzyme';
import Registration from './Registration';

describe('<Registration />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<Registration />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});

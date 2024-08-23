import React from 'react';
import { shallow } from 'enzyme';
import Logo from './Logo';

describe('<Logo />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<Logo />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});

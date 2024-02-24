#root finding using newton-raphson method
# import sympy as sp
def newton_raphson(f,df,x0,N):
    for i in range(0,N):
        x0 = x0 - f(x0)/df(x0)
    return x0
f = lambda x: x**2 - x - 1
df = lambda x: 2*x - 1
x0 = 1
x1 = 2
N = 3
approx_phi = newton_raphson(f,df,x0,N)
print(approx_phi)
